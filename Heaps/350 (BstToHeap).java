package com.Nikunj.Heaps.Q11;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left, right;
    Node(int d){
        data = d;
        left = right = null;
    }
}

public class BstToHeap {
    int heap[];
    int size;
    int capacity;
    BstToHeap(int n){
        this.heap = new int[n];
        this.size = 0;
        this.capacity = n;
    }
    public int parent(int i){
        return (i-1)/2;
    }
    public int left(int i){
        return (2*i+1);
    }
    public int right(int i){
        return (2*i+2);
    }
    public void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    public void heapify(int i){
        int smallest = i;
        int l = left(i);
        int r = right(i);
        if (l<size && heap[l]<heap[smallest]){
            smallest = l;
        }
        if (r<size && heap[r]<heap[smallest]){
            smallest = r;
        }
        if (i == smallest) return;
        swap(i,smallest);
        heapify(smallest);
    }
    public int extract(){
        int popped = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return popped;
    }
    public void insert(int element){
        size++;
        if (size>capacity) return;
        heap[size-1] = element;
        int i = size-1;
        while (heap[parent(i)]>heap[i]){
            heapify(parent(i));
            i = parent(i);
        }
    }

    Node root;
    public void toHeap(){
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node tempNode = q.remove();
//            System.out.print(tempNode.data + " ");
            insert(tempNode.data);
            if (tempNode.left!=null){
                q.add(tempNode.left);
            }
            if (tempNode.right!=null){
                q.add(tempNode.right);
            }
        }
    }
    public void check(){
        for (int i = 0; i<(size-1)/2; i++){
            if (heap[left(i)]>heap[right(i)]){
                swap(left(i), right(i));
            }
        }
    }

    public static void main(String[] args) {
        BstToHeap bst = new BstToHeap(10);
        bst.root = new Node(4);
        bst.root.left = new Node(2);
        bst.root.right = new Node(6);
        bst.root.left.left = new Node(1);
        bst.root.left.right = new Node(3);
        bst.root.right.left = new Node(5);
        bst.root.right.right = new Node(7);
        bst.toHeap();
        for (int i = 0; i<bst.size; i++){
            System.out.print(bst.heap[i] + " ");
        }
        System.out.println();
        bst.check();
        for (int i = 0; i<bst.size; i++){
            System.out.print(bst.heap[i] + " ");
        }
    }
}
