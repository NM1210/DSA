package graphs;

import java.util.*;
import java.util.Map.Entry;

class Node implements Comparator<Node>{
	private int u, v, w;
	Node(int node1, int node2, int weight){
		u = node1;
		v = node2;
		w = weight;
	}
	Node(){}
	
	@Override
	public int compare(Node o1, Node o2) {
		if(o1.getW()<o2.getW()) return -1;
		else if(o1.getW()>o2.getW()) return 1;
		return 0;
	}
	public int getU() {
		return u;
	}
	public int getV() {
		return v;
	}
	public int getW() {
		return w;
	}
}

class DisjointSet{
	private int parent[];
	private int rank[];
	
	DisjointSet(int n){
		parent = new int[n];
		for(int i = 0; i<n; i++) {
			parent[i] = i;
		}
//		parent[7] = 6;
//		parent[6] = 5;
//		parent[5] = 4;
		rank = new int[n];
		Arrays.fill(rank, 0);
	}
	
//	void path_compression(int node) {
//		if(parent[node]==node) return;
//		path_compression(parent[node]);
//		parent[node] = get_parent(node);
//	}
	
	void union(int node1, int node2) {
		int parent_node1 = get_parent(node1);
		int parent_node2 = get_parent(node2);
		
		if(rank[parent_node1]==rank[parent_node2]) {
			parent[parent_node2] = parent_node1;
			rank[parent_node1]++;
//			path_compression(node2);
		}
		else if(rank[parent_node1]>rank[parent_node2]) {
//			path_compression(node1);
			
			parent[parent_node2] = parent_node1;
//			path_compression(node2);
		}
		else if(rank[parent_node1]<rank[parent_node2]) {
//			path_compression(node2);
			
			parent[parent_node1] = parent_node2;
//			path_compression(node1);
		}
	}
	
	int get_parent(int node) {
		if(parent[node]==node) return node;
		parent[node] = get_parent(parent[node]);
		return parent[node];
	}
	
	void Print() {
		for(int i = 0; i<parent.length; i++) {
			System.out.print(parent[i]);
		}
//		for(int i = 0; i<rank.length; i++) {
//			System.out.print(rank[i]);
//		}
		System.out.println();
	}
	
}

class Pair implements Comparator<Pair>{
    private int element0;
    private int element1;

    public static Pair createPair(int element0, int element1) {
        return new Pair(element0, element1);
    }

    public Pair(int element0, int element1) {
        this.element0 = element0;
        this.element1 = element1;
    }
    
    Pair() {}

    public int getElement0() {
        return element0;
    }

    public int getElement1() {
        return element1;
    }

	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.element1<o2.element1) return -1;
		if(o1.element1>o2.element1) return 1;
		return 0;
	}
}

public class Graph {
	
	HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
	int timer;
	
	void bfs() {
//		System.out.println(map.size()+1);
		int visited[] = new int[map.size()+1];
//		System.out.println(visited.length);
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<map.size()+1; i++) {
//			System.out.println(visited[i]);
			if(visited[i]!=1) {
				visited[i] = 1;
				q.add(i);
				while(!q.isEmpty()) {
					int at = q.poll();
					System.out.print(at);
					for (int j = 0; j<map.get(at).size(); j++) {
						if(visited[map.get(at).get(j).getElement0()]!=1) {
							visited[map.get(at).get(j).getElement0()] = 1;
							q.add(map.get(at).get(j).getElement0());
						}
					}
				}
			}
		}
	}
	
	void dfs(int i, int[] visited) {
		visited[i] = 1;
		System.out.print(i+" ");
		for(int j = 0; j<map.get(i).size(); j++) {
			if(visited[map.get(i).get(j).getElement0()]!=1) {
				dfs(map.get(i).get(j).getElement0(), visited);
			}
		}
	}
	
	void start_dfs(int n) {
		int visited[] = new int[n];
		for(int i = 1; i<n; i++) {
			if(visited[i]!=1) {
				dfs(i, visited);
			}
		}
	}
	
	boolean cycle_bfs() {
		int visited[] = new int[map.size()+1];
		Queue<Pair> q = new LinkedList<>();
		for(int i = 1; i<map.size()+1; i++) {
			if(visited[i]!=1) {
				int prev = -1;
				visited[i] = 1;
				Pair pair = Pair.createPair(i, prev);
				q.add(pair);
				while(!q.isEmpty()) {
					Pair at = q.poll();
//					System.out.println(at.element0 + " " + at.element1);
					for (int j = 0; j<map.get(at.getElement0()).size(); j++) {
						if(visited[map.get(at.getElement0()).get(j).getElement0()]==1 && map.get(at.getElement0()).get(j).getElement0()!=prev) {
							return true;
						}
						if(visited[map.get(at.getElement0()).get(j).getElement0()]!=1) {
							visited[map.get(at.getElement0()).get(j).getElement0()] = 1;
							prev = at.getElement0();
							Pair element = Pair.createPair(map.get(at.getElement0()).get(j).getElement0(), prev);
							q.add(element);
						}
					}
				}
			}
		}
		return false;
	}
	
	boolean cycle_dfs(int i, int prev, int[] visited) {
		visited[i] = 1;
//		System.out.print(i);
		for(int j = 0; j<map.get(i).size(); j++) {
			if(visited[map.get(i).get(j).getElement0()]!=1) {
				if(cycle_dfs(map.get(i).get(j).getElement0(), i, visited)==true) return true;
			}
			else if(visited[map.get(i).get(j).getElement0()] == 1 && map.get(i).get(j).getElement0()!=prev) {
				return true;
			}
//			else if(visited[map.get(i).get(j).element0]!=1) {
//				cycle_dfs(map.get(i).get(j).element0, i, visited);
//			}
		}
		return false;
	}
	
	boolean start_cycle_dfs(int n) {
		int visited[] = new int[n];
		for(int i = 1; i<n; i++) {
			if(visited[i]!=1) {
				int prev = -1;
				return cycle_dfs(i, prev, visited);
			}
		}
		return false;
	}
	
	boolean bipartite_bfs() {
		int colors[] = new int[map.size()+1];
		Arrays.fill(colors, -1);
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<map.size()+1; i++) {
			int color = 0;
			if(colors[i]==-1) {
				colors[i] = color;
				q.add(i);
				while(!q.isEmpty()) {
					int at = q.poll();
					color = (colors[at]==0) ? 1 : 0;
					for (int j = 0; j<map.get(at).size(); j++) {
						if(colors[map.get(at).get(j).getElement0()]==-1) {
							colors[map.get(at).get(j).getElement0()] = color;
							q.add(map.get(at).get(j).getElement0());
						}
						else if(colors[map.get(at).get(j).getElement0()]!=color){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	boolean bipartite_dfs(int i, int color, int[] colors) {
		colors[i] = color;
//		System.out.print(i);
		color = (color==0) ? 1: 0;
		for(int j = 0; j<map.get(i).size(); j++) {
			if(colors[map.get(i).get(j).getElement0()]==-1) {
				if(bipartite_dfs(map.get(i).get(j).getElement0(), color, colors)==false) return false;
			}
			else if(colors[map.get(i).get(j).getElement0()]!=color){
				return false;
			}
		}
		return true;
	}
	
	boolean start_bipartite_dfs(int n) {
		int colors[] = new int[n];
		int color = 0;
		Arrays.fill(colors,-1);
		for(int i = 1; i<n; i++) {
			if(colors[i]==-1) {
				if(!bipartite_dfs(i, color, colors)) return false;
			}
		}
		return true;
	}
	
	boolean dfs_directed(int i, int[] visited, int dfs_visited[]) {
		visited[i] = 1;
		dfs_visited[i] = 1;
//		System.out.print(i);
		if(map.containsKey(i)) {
			for(int j = 0; j<map.get(i).size(); j++) {
				if(visited[map.get(i).get(j).getElement0()] == 1 && dfs_visited[map.get(i).get(j).getElement0()] == 1) {
					return true;
				}
				if(dfs_directed(map.get(i).get(j).getElement0(), visited, dfs_visited)) return true;
			}
		}
		dfs_visited[i] = 0;
		return false;
	}
	
	boolean cycle_dfs_directed(int n) {
		int visited[] = new int[n];
		int dfs_visited[] = new int[n];
		for(int i = 1; i<n; i++) {
			if(visited[i]!=1) {
				if(dfs_directed(i, visited, dfs_visited)) return true;
			}
		}
		return false;
	}
	
	void sort_dfs(int i, int[] visited, Stack<Integer> topo) {
		visited[i] = 1;
//		System.out.print(i);
		if(map.containsKey(i)) {
			for(int j = 0; j<map.get(i).size(); j++) {
				if(visited[map.get(i).get(j).getElement0()]!=1) {
					sort_dfs(map.get(i).get(j).getElement0(), visited, topo);
				}
			}
		}
		topo.push(i);
	}
	
	Stack<Integer> topological_sort_dfs(int n) {
//		if(cycle_dfs_directed(n)) {
//			System.out.println("not Acyclic!");
////			return null;
//		}
		int visited[] = new int[n];
		Stack<Integer> topo = new Stack<Integer>();
		for(int i = this.get_min(); i<n; i++) {
			if(visited[i]!=1) {
				sort_dfs(i, visited, topo);
			}
		}
//		while(!topo.isEmpty()) {
//			System.out.print(topo.pop());
//		}
		return topo;
	}
	
	void topological_sort_bfs(int n) {
		int indegree[] = new int[n];
		for(int i = 1; i<n; i++) {
			if(map.containsKey(i)) {
				for(Pair p: map.get(i)) {
					indegree[p.getElement0()]++;
				}
			}
		}
//		for(int i = 0; i<n; i++) {
//			System.out.print(indegree[i]);
//		}
//		System.out.println();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<n; i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
			while(!q.isEmpty()) {
				int curr = q.remove();
				System.out.print(curr);
				if(map.containsKey(curr)) {
					for(int j = 0; j<map.get(curr).size(); j++) {
						indegree[map.get(curr).get(j).getElement0()]--;
						if(indegree[map.get(curr).get(j).getElement0()]==0) {
							q.add(map.get(curr).get(j).getElement0());
						}
					}
				}
			}
		}
	}
	
	boolean cycle_bfs_directed(int n) {
		int indegree[] = new int[n];
		for(int i = 1; i<n; i++) {
			if(map.containsKey(i)) {
				for(Pair p: map.get(i)) {
					indegree[p.getElement0()]++;
				}
			}
		}
		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		for(int i = 1; i<n; i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
			while(!q.isEmpty()) {
				int curr = q.remove();
//				System.out.print(curr);
				count++;
//				System.out.print(count);
				if(map.containsKey(curr)) {
					for(int j = 0; j<map.get(curr).size(); j++) {
						indegree[map.get(curr).get(j).getElement0()]--;
						if(indegree[map.get(curr).get(j).getElement0()]==0) {
							q.add(map.get(curr).get(j).getElement0());
						}
					}
				}
			}
		}
		if(count==n-1) return false;
		return true;
	}
	
	void shortest_distance(int n, int source) {
		int distance[] = new int[n];
		for(int i = 0; i<n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		distance[source] = 0;
		while(!q.isEmpty()) {
			int node = q.remove();
			int dis = distance[node];
			for(int i = 0; i<map.get(node).size(); i++) {
				if(dis + map.get(node).get(i).getElement1() < distance[map.get(node).get(i).getElement0()]) {
					distance[map.get(node).get(i).getElement0()] = dis + map.get(node).get(i).getElement1();
					q.add(map.get(node).get(i).getElement0());
				}
			}
		}
		for(int i = 0; i<n; i++) {
			System.out.print(distance[i]+" ");
		}
	}
	
	void shortest_distance_directed(int n, int source) {
		int distance[] = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Stack<Integer> topo = topological_sort_dfs(n);
		distance[source] = 0;
		while(!topo.isEmpty()) {
			int node = topo.pop();
			if(distance[node]!=Integer.MAX_VALUE) {
				if(map.containsKey(node)) {
					for(int i = 0; i<map.get(node).size(); i++) {
						if(distance[node]+map.get(node).get(i).getElement1()<distance[map.get(node).get(i).getElement0()]) {
							distance[map.get(node).get(i).getElement0()] = distance[node]+map.get(node).get(i).getElement1();
						}
					}
				}
			}
		}
		for(int i = 0; i<n; i++) {
			System.out.print(distance[i]+" ");
		}
	}
	
	void longest_distance_directed(int n, int source) {
		int distance[] = new int[n];
		Arrays.fill(distance, Integer.MIN_VALUE);
		Stack<Integer> topo = topological_sort_dfs(n);
		distance[source] = 0;
		while(!topo.isEmpty()) {
			int node = topo.pop();
			if(distance[node]!=Integer.MIN_VALUE) {
				if(map.containsKey(node)) {
					for(int i = 0; i<map.get(node).size(); i++) {
						if(distance[node]+map.get(node).get(i).getElement1()>distance[map.get(node).get(i).getElement0()]) {
							distance[map.get(node).get(i).getElement0()] = distance[node]+map.get(node).get(i).getElement1();
						}
					}
				}
			}
		}
		for(int i = 0; i<n; i++) {
			System.out.print(distance[i]+" ");
		}
	}
	
	int dijkstra(int n, int source, int des) {
		int distance[] = new int[n];
		for(int i = 0; i<n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Pair> q = new PriorityQueue<Pair>(n, new Pair(source, 0));
		distance[source] = 0;
		q.add(new Pair(source, distance[source]));
		while(!q.isEmpty()) {
			Pair node = q.remove();
			for(int i = 0; i<map.get(node.getElement0()).size(); i++) {
				if(node.getElement1() + map.get(node.getElement0()).get(i).getElement1() < distance[map.get(node.getElement0()).get(i).getElement0()]) {
					distance[map.get(node.getElement0()).get(i).getElement0()] = node.getElement1() + map.get(node.getElement0()).get(i).getElement1();
					q.add(new Pair(map.get(node.getElement0()).get(i).getElement0(), distance[map.get(node.getElement0()).get(i).getElement0()]));
				}
			}
		}
//		for(int i = 0; i<n; i++) {
//			if(distance[i]!=Integer.MAX_VALUE) {
//				System.out.print(distance[i]+" ");
//			}
//		}
//		System.out.print(distance[des]+" ");
		return distance[des];
	}
	
	boolean bellman_ford(int n) {
		long distance[] = new long[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[this.get_min()] = 0;
//		for(int i = 0; i<n; i++) {
//			System.out.print(distance[i] + " ");
//		}
//		int a = distance[5]-6;
//		System.out.println();
		for(int itr = 0; itr<n-1; itr++) {
			for(int i = this.get_min(); i<n; i++) {
				if(map.containsKey(i)) {
					for(int j = 0; j<map.get(i).size(); j++) {
//						System.out.println(distance[i]+" "+map.get(i).get(j).getElement1()+","+distance[map.get(i).get(j).getElement0()]);
						if(distance[i] + map.get(i).get(j).getElement1() < distance[map.get(i).get(j).getElement0()]) {
							distance[map.get(i).get(j).getElement0()] = distance[i] + map.get(i).get(j).getElement1();
						}
					}				
				}
			}			
		}
		for(int i = this.get_min(); i<n; i++) {
			if(map.containsKey(i)) {
				for(int j = 0; j<map.get(i).size(); j++) {
//					System.out.println(distance[i]+" "+map.get(i).get(j).getElement1()+","+distance[map.get(i).get(j).getElement0()]);
					if(distance[i] + map.get(i).get(j).getElement1() < distance[map.get(i).get(j).getElement0()]) {
						return true;
					}
				}				
			}
		}	
//		System.out.println();
		for(int i = 0; i<n; i++) {
			System.out.print(distance[i] + " ");
		}
		return false;
	}
	
	boolean check(boolean mst[]) {
		for(int i = 0; i<mst.length; i++) {
			if(mst[i]!=true) return false;
		}
		return true;
	}
	
	int get_min(int keys[], boolean mst[]) {
		int min = Integer.MAX_VALUE;
		int index = 0;
		int i = 0;
		while(i<mst.length) {
			if(mst[i]!=true && keys[i]<min) {
				min = keys[i];
				index = i;
			}
			i++;
		}
		return index;
	}
	
	void prims(int n) {
		int keys[] = new int[n];
		boolean mst[] = new boolean[n];
		int parent[] = new int[n];
		Arrays.fill(keys, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		keys[0] = 0;
		while(!check(mst)) {
			int curr = get_min(keys, mst);
//			System.out.println(curr);
			mst[curr] = true;
			for(int i = 0; i<map.get(curr).size(); i++) {
				if(map.get(curr).get(i).getElement1()<keys[map.get(curr).get(i).getElement0()] && mst[map.get(curr).get(i).getElement0()]!=true) {
					keys[map.get(curr).get(i).getElement0()] = map.get(curr).get(i).getElement1();
					parent[map.get(curr).get(i).getElement0()] = curr;
				}
			}
		}
		for(int i = 0; i<n; i++) {
			System.out.print(parent[i]+" ");
		}
	}
	
	void prims_efficient(int n) {
		int keys[] = new int[n];
		boolean mst[] = new boolean[n];
		int parent[] = new int[n];
		Arrays.fill(keys, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		keys[0] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(n, new Pair());
		pq.add(new Pair(0, keys[0]));
		while(!pq.isEmpty()) {
			Pair curr = pq.poll();
//			System.out.println(curr);
			mst[curr.getElement0()] = true;
			for(int i = 0; i<map.get(curr.getElement0()).size(); i++) {
				if(map.get(curr.getElement0()).get(i).getElement1()<keys[map.get(curr.getElement0()).get(i).getElement0()] && mst[map.get(curr.getElement0()).get(i).getElement0()]!=true) {
					keys[map.get(curr.getElement0()).get(i).getElement0()] = map.get(curr.getElement0()).get(i).getElement1();
					pq.add(new Pair(map.get(curr.getElement0()).get(i).getElement0(), keys[map.get(curr.getElement0()).get(i).getElement0()]));
					parent[map.get(curr.getElement0()).get(i).getElement0()] = curr.getElement0();
				}
			}
		}
		for(int i = 0; i<n; i++) {
			System.out.print(parent[i]+" ");
		}
		System.out.println();
	}
	
	void kruskals(int n) {
//		Graph mst = new Graph();
		DisjointSet set = new DisjointSet(n);
//		set.Print();
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Node());
		for(Entry<Integer, ArrayList<Pair>> entry : map.entrySet()) {
			for(Pair node : entry.getValue()) {
				if(entry.getKey()<node.getElement0()) {
					pq.add(new Node(entry.getKey(), node.getElement0(), node.getElement1()));					
				}
			}
		}
		while(!pq.isEmpty()) {
			Node node = pq.poll();
//			System.out.println(node.getU() + " " + node.getV() + " " + node.getW());
			if(set.get_parent(node.getU())!=set.get_parent(node.getV())) {
				set.union(node.getU(), node.getV());
				System.out.println(node.getU() + " " + node.getV() + " " + node.getW());
//				mst.addEdge(node.getU(), node.getV(), node.getW(), 1);
			}
		}
//		set.Print();
//		mst.printGraph();
	}
	
	void bridges(int node, int par, int[] disc, int[] low, int[] parent) {
		disc[node] = timer;
		low[node] = timer;
		parent[node] = par;
		timer++;
//		System.out.print(node);
		for(int i = 0; i<map.get(node).size(); i++) {
			if(map.get(node).get(i).getElement0()!=parent[node]) {
				if(disc[map.get(node).get(i).getElement0()] == -1) {
					bridges(map.get(node).get(i).getElement0(), node, disc, low, parent);
				}
				low[node] = Math.min(low[node], low[map.get(node).get(i).getElement0()]);
				if(low[map.get(node).get(i).getElement0()]>disc[node]) {
					System.out.println(node+" - "+map.get(node).get(i).getElement0());
				}
			}
		}
		return;
	}
	
	void articulation_point(int node, int par, HashSet<Integer> articulation_points, int[] disc, int[] low, int[] parent) {
		disc[node] = timer;
		low[node] = timer;
		parent[node] = par;
		timer++;
		int child = 0;
//		System.out.print(node);
		for(int i = 0; i<map.get(node).size(); i++) {
			if(map.get(node).get(i).getElement0()!=parent[node]) {
				if(disc[map.get(node).get(i).getElement0()] == -1) {
					articulation_point(map.get(node).get(i).getElement0(), node, articulation_points, disc, low, parent);
					child++;
				}
				low[node] = Math.min(low[node], low[map.get(node).get(i).getElement0()]);
				if(low[map.get(node).get(i).getElement0()]>=disc[node] && parent[node]!=-1) {
					articulation_points.add(node);
				}
				if(child > 1 && parent[node] == -1) {
					articulation_points.add(node);
				}
			}
		}
		return;
	}
	
	void ssc(int node, Stack<Integer> stack, int[] disc, int[] low, boolean[] inStack) {
		disc[node] = timer;
		low[node] = timer;
		stack.push(node);
		inStack[node] = true;
		timer++;
//		System.out.print(node);
		if(map.containsKey(node)) {
			for(int i = 0; i<map.get(node).size(); i++) {
				if(disc[map.get(node).get(i).getElement0()] == -1) {
					ssc(map.get(node).get(i).getElement0(), stack, disc, low, inStack);
					low[node] = Math.min(low[node], low[map.get(node).get(i).getElement0()]);
				}
				else if(disc[map.get(node).get(i).getElement0()] != -1 && inStack[map.get(node).get(i).getElement0()] == true) {
					low[node] = Math.min(low[node], disc[map.get(node).get(i).getElement0()]);
				}
			}
		}
//		if(node==3) System.out.println(disc[node]+" "+low[node]);
		if(disc[node] == low[node]) {
			System.out.print("ssc - ");
			while(stack.peek()!=node) {
				inStack[stack.peek()] = false;
				System.out.print(stack.pop() + " ");
			}
			inStack[stack.peek()] = false;
			System.out.println(stack.pop());
		}
		return;
	}
	
	void tarjan(int n) {
		int disc[] = new int[n];
		int low[] = new int[n];
		int parent[] = new int[n];
		boolean inStack[] = new boolean[n];
		HashSet<Integer> articulation_points = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);
		Arrays.fill(parent, -1);
//		bridges(1, -1, disc, low, parent);
//		System.out.println(articulation_points.size());
//		articulation_point(1, -1, articulation_points, disc, low, parent);
//		System.out.println(articulation_points.size());
//		for(Integer point: articulation_points) {
//			System.out.println(point);
//		}
//		System.out.println(this.get_min()+" "+(this.get_max()+1));
		ssc(this.get_min(), stack, disc, low, inStack);
	}
	
	void kosaraju(int n) {
		int visited[] = new int[n];
		Stack<Integer> topo = this.topological_sort_dfs(n);
//		while(!topo.isEmpty()) {
//			System.out.print(topo.pop());
//		}
		this.transpose(n);
		while(!topo.isEmpty()) {
			if(visited[topo.peek()]==1) {
				topo.pop();
			}
			else {
				System.out.print("ssc - ");
				this.dfs(topo.peek(), visited);
				topo.pop();
				System.out.println();
			}
		}
	}
	
	void chineseSalesman(int n) {
		int degree[] = new int[n];
		for(int i = 0; i<n; i++) {
			degree[i] = map.get(i).size();
		}
//		for(int i = 0; i<n; i++) {
//			System.out.print(degree[i]+" ");
//		}
		ArrayList<Integer> odd = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			if(degree[i]%2!=0) {
				odd.add(i);
			}
		}
//		for(Integer i: odd) {
//			System.out.print(i+" ");
//		}
		ArrayList<ArrayList<Integer>> odd_pairs = new ArrayList<>();
		for(int i = 0; i<=odd.size(); i++) {
			for(int j = i+1; j<odd.size(); j++) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(odd.get(i));
				temp.add(odd.get(j));
				odd_pairs.add(temp);
			}
		}
//		for(ArrayList<Integer> list: odd_pairs) {
//			for(Integer i: list) {
//				System.out.print(i+" ");
//			}
//			System.out.print(",");
//		}
//		System.out.println(dijkstra(n, 0, 5));
		ArrayList<ArrayList<ArrayList<Integer>>> pairs = new ArrayList<>();
		for(int i = 0; i<odd_pairs.size()/2; i++) {
			for(int j = i+1; j<odd_pairs.size(); j++) {
				if(odd_pairs.get(i).get(0)!=odd_pairs.get(j).get(0)&&odd_pairs.get(i).get(0)!=odd_pairs.get(j).get(1)&&
				   odd_pairs.get(i).get(1)!=odd_pairs.get(j).get(0)&&odd_pairs.get(i).get(1)!=odd_pairs.get(j).get(1)) {
					ArrayList<Integer> list1 = new ArrayList<>();
					list1.add(odd_pairs.get(i).get(0));
					list1.add(odd_pairs.get(i).get(1));
					ArrayList<Integer> list2 = new ArrayList<>();
					list2.add(odd_pairs.get(j).get(0));
					list2.add(odd_pairs.get(j).get(1));
					ArrayList<ArrayList<Integer>> list = new ArrayList<>();
					list.add(list1);
					list.add(list2);
					pairs.add(list);
				}
			}
		}
//		for(ArrayList<ArrayList<Integer>> list: pairs) {
//			for(ArrayList<Integer> pair: list) {
//				for(Integer i: pair) {
//					System.out.print(i);
//				}
//				System.out.print(",");
//			}
//			System.out.print(" ");
//		}
		int min = Integer.MAX_VALUE;
		ArrayList<ArrayList<Integer>> duplicate = new ArrayList<>();
		for(ArrayList<ArrayList<Integer>> list: pairs) {
			int sum = 0;
			for(ArrayList<Integer> pair: list) {
				sum += dijkstra(n, pair.get(0), pair.get(1));
			}
			if(sum<min) {
				min = sum;
				duplicate = list;
			}
		}
		for(ArrayList<Integer> pair: duplicate) {
			System.out.print(pair.get(0)+""+pair.get(1)+", ");
		}
		System.out.println();
		System.out.print(min);
	}
	
	void transpose(int n) {
		int visited[] = new int[n];
		Arrays.fill(visited, -1);
		int parent[] = new int[n];
		Arrays.fill(parent, -1);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(this.get_min());
		visited[this.get_min()] = 1;
		while(!q.isEmpty()) {
			int curr = q.poll();
//			System.out.println(curr);
			for(int i = 0; i<map.get(curr).size(); ) {
				if(visited[map.get(curr).get(i).getElement0()]==-1) {
					this.addEdge(map.get(curr).get(i).getElement0(), curr, 0, 0);
					q.add(map.get(curr).get(i).getElement0());
					visited[map.get(curr).get(i).getElement0()] = 1;
					parent[map.get(curr).get(i).getElement0()] = curr;
					this.remove_edge(curr, map.get(curr).get(i));
				}
				else if(visited[map.get(curr).get(i).getElement0()]!=-1 && parent[curr]!=map.get(curr).get(i).getElement0()) {
					this.addEdge(map.get(curr).get(i).getElement0(), curr, 0, 0);
					this.remove_edge(curr, map.get(curr).get(i));
					i++;
				}
				else {
					i++;		//EUREKA MOMENT!!
				}
			}
		}
	}
	
	void minEdgeReversal(int src, int des) {
		int n = get_max()+1;
		dijkstra(n, src, des);
	}
	
	void reverse_graph(int[][] edges) {
		for(int i = 0; i<edges.length; i++) {
			add_edge(edges[i][0], edges[i][1]);
		}
	}
	
	void add_edge(int u, int v){
        if(!map.containsKey(u)){
            Pair pair = Pair.createPair(v, 0);
            ArrayList<Pair> list = new ArrayList<Pair>();
            list.add(pair);
            map.put(u, list);
        }
        else{
            Pair pair = new Pair(v, 0);
            ArrayList<Pair> list = map.get(u);
            list.add(pair);
            map.put(u, list);
        }
        if(!map.containsKey(v)){
            Pair pair = Pair.createPair(u, 1);
            ArrayList<Pair> list = new ArrayList<Pair>();
            list.add(pair);
            map.put(v, list);
        }
        else{
            Pair pair = new Pair(u, 1);
            ArrayList<Pair> list = map.get(v);
            list.add(pair);
            map.put(v, list);
        }
    }
	
	void remove_edge(int from, Pair to) {
		map.get(from).remove(map.get(from).indexOf(to));
//		g.map.get(3).get(g.map.get(3).indexOf());
	}
	
	void addEdge(int u, int v, int w, int direction){
        if(!map.containsKey(u)){
            Pair pair = Pair.createPair(v, w);
            ArrayList<Pair> list = new ArrayList<Pair>();
            list.add(pair);
            map.put(u, list);
        }
        else{
            Pair pair = new Pair(v, w);
            ArrayList<Pair> list = map.get(u);
            list.add(pair);
            map.put(u, list);
        }
        if(direction == 1){
            addEdge(v, u, w, 0);
        }
    }
	
	int get_max() {
		int max = Integer.MIN_VALUE;
		for(Integer key: map.keySet()) {
			if(key>max) max = key;
			for(int j = 0; j<map.get(key).size(); j++) {
				if(map.get(key).get(j).getElement0()>max) max = map.get(key).get(j).getElement0();
			}
		}
		return max;
	}
	
	int get_min() {
		int min = Integer.MAX_VALUE;
		for(Integer key: map.keySet()) {
			if(key<min) min = key;
			for(int j = 0; j<map.get(key).size(); j++) {
				if(map.get(key).get(j).getElement0()<min) min = map.get(key).get(j).getElement0();
			}
		}
		return min;
	}
	
	void printGraph() {
		for(Entry<Integer, ArrayList<Pair>> entry : map.entrySet()) {
			System.out.print(entry.getKey() + "->");
			for(Pair node : entry.getValue()) {
				System.out.print("("+node.getElement0()+","+node.getElement1()+")->");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
//		g.addEdge(0, 1,4, 0);
//		g.addEdge(0, 7,8, 0);
//		g.addEdge(0, 1, 2, 0);
		g.addEdge(0, 1, 3, 1);
		g.addEdge(0, 2, 1, 1);
		g.addEdge(0, 4, 5, 1);
		g.addEdge(1, 3, 1, 1);
		g.addEdge(1, 5, 6, 1);
		g.addEdge(2, 4, 2, 1);
		g.addEdge(3, 5, 1, 1);		
		g.addEdge(4, 5, 4, 1);
//		g.addEdge(0, 1, 1, 1);		
//		g.addEdge(1, 2, 2, 1);
//		g.addEdge(1, 4, 1, 1);
//		g.addEdge(1, 5, 4, 1);
//		g.addEdge(2, 3, 3, 1);
//		g.addEdge(2, 4, 3, 1);
//		g.addEdge(2, 6, 7, 1);
//		g.addEdge(3, 4, 5, 1);
//		g.addEdge(3, 6, 8, 1);
//		g.addEdge(4, 5, 9, 1);
//		g.addEdge(5, 6, 9, 1);
//		g.addEdge(6, 7, 9, 1);
//		g.addEdge(6, 9, 9, 1);
//		g.addEdge(7, 8, 9, 1);
//		g.addEdge(8, 9, 9, 1);
//		g.addEdge(8, 10, 9, 1);
//		g.addEdge(10, 11, 9, 1);
//		g.addEdge(10, 12, 9, 1);
//		g.addEdge(11, 12, 9, 1);
//		g.addEdge(0, 1, 5, 0);
//		g.addEdge(1, 2, -2, 0);
//		g.addEdge(1, 5, -3, 0);
//		g.addEdge(2, 4, 3, 0);
//		g.addEdge(3, 2, 6, 0);
//		g.addEdge(3, 4, -2, 0);
////		g.addEdge(5, 0, -5, 0);
//		g.addEdge(5, 3, 1, 0);
////		g.addEdge(4, 6, 0, 0);
////		g.addEdge(5, 2, 0, 0);
////		g.addEdge(5, 6, 0, 0);
////		g.addEdge(6, 5, 0, 0);
//		g.addEdge(0, 1, 5, 0);
//		g.addEdge(0, 2, 3, 0);
//		g.addEdge(1, 3, 6, 0);
//		g.addEdge(1, 2, 2, 0);
//		g.addEdge(2, 4, 4, 0);
//		g.addEdge(2, 5, 2, 0);
//		g.addEdge(2, 3, 7, 0);
//		g.addEdge(3, 5, 1, 0);
//		g.addEdge(3, 4, -1, 0);
//		g.addEdge(4, 5, -2, 0);

		g.printGraph();
		
//		g.map.get(3).get(g.map.get(3).indexOf(pair))
//		int n = map.size()+1;
//		int n = Collections.max(map.keySet());
		int n = g.get_max()+1;
		System.out.println(g.get_min()+" "+n);
//		g.transpose(n);
//		g.printGraph();
//		g.bfs();
//		System.out.println();
//		g.start_dfs(n);
//		System.out.println(g.cycle_bfs());
//		System.out.println(g.start_cycle_dfs(n));
//		System.out.println(g.bipartite_bfs());
//		System.out.println(g.start_bipartite_dfs(n));
//		System.out.println(g.cycle_dfs_directed(n));
//		Stack<Integer> topo = g.topological_sort_dfs(n);
//		while(!topo.isEmpty()) {
//			System.out.print(topo.pop());
//		}
//		System.out.println();
//		g.topological_sort_bfs(n);
//		System.out.println(g.cycle_bfs_directed(n));
//		g.shortest_distance(n, 0);
//		g.shortest_distance_directed(n, 1);
//		g.longest_distance_directed(n, 1);
//		g.dijkstra(n, 1);
//		g.prims(n);
//		g.prims_efficient(n);
//		g.kruskals(n);
//		g.tarjan(n);
//		g.kosaraju(n);
//		System.out.println(g.bellman_ford(n));
		
//		int edges[][] = { { 0, 1 }, { 2, 1 },{ 2, 3 }, { 5, 1 },{ 4, 5 }, { 6, 4 },{ 6, 3 } };
//		g.reverse_graph(edges);
//		g.minEdgeReversal(0, 6);
//		g.printGraph();
		
		g.chineseSalesman(n);
		
//		DisjointSet set = new DisjointSet(9);
////		System.out.println(set.get_parent(2));
//		set.Print();
//		set.union(1, 2);
//		System.out.println();
//		set.Print();
//		set.union(2, 3);
//		System.out.println();
//		set.Print();
//		set.union(4, 5);
//		System.out.println();
//		set.Print();
//		set.union(6, 7);
//		System.out.println();
//		set.Print();
//		set.union(5, 6);
//		System.out.println();
//		set.Print();
//		set.union(3, 7);
//		System.out.println();
//		set.Print();
//		set.union(2, 8);
//		System.out.println();
//		set.Print();
//		set.union(3, 9);
//		System.out.println();
//		set.Print();
////		System.out.println(set.get_parent(2));
////		set.Print();
////		System.out.println();
////		set.Print();
		
	}

}
