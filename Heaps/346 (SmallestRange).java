package com.Nikunj.Heaps.Q21;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestRange {
    static int[][] input = {{4, 7, 9, 12, 15},
            {1, 8, 10, 14, 20},
            {6, 12, 16, 30, 50}};
    static int[] j = new int[input.length];

    PriorityQueue<Element> heap = new PriorityQueue<>(new ElementComparator());
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        SmallestRange minHeap = new SmallestRange();

        for (int i = 0; i < input.length; i++){
            minHeap.pq.add(input[i][j[i]]);
        }
        Element e = minHeap.calcRange();
        System.out.print(minHeap.heap.size());
        System.out.print(e.last+"-"+e.first+"="+e.diff);
    }

    public Element calcRange(){
        int f = 0;
        for (int i = 0; i< input.length; i++){
            if (j[i]==input[i].length) f++;
        }
        if (f == 3){
            return heap.remove();
        }

            System.out.print(pq.peek());
            if (!pq.isEmpty()) {
                heap.add(new Element(pq.peek(), (Integer) pq.toArray()[pq.size() - 1]));
                for (int i = 0; i < input.length; i++) {
                    if (!pq.isEmpty()) {
                        if (pq.peek() == input[i][j[i]]) {
                            pq.remove();
                            if (j[i] + 1 < input[i].length) {
                                pq.add(input[i][j[i] + 1]);
                                j[i]++;
                            } else {
//                                pq.remove();
                                for (int i1 = 0; i1 < input.length; i1++) {
                                    if (!pq.isEmpty()) {
                                        if (pq.peek() == input[i][j[i]]) {
                                            if (j[i] + 1 <= input.length - 1) {
                                                pq.add(input[i][j[i] + 1]);
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            pq.remove();
                            PriorityQueue<Integer> temp = new PriorityQueue<>();
                            while (!pq.isEmpty()) {
                                int removed = pq.poll();
                                for (int i1 = 0; i1 < input.length; i1++) {
                                    if (removed == input[i][j[i]]) {
                                        if (j[i] + 1 <= input.length - 1) {
                                            temp.add(removed);
                                        } else {
                                            temp.add(removed);
                                            temp.add(input[i][j[i] + 1]);
                                        }
                                    }
                                }
                            }
                            pq = temp;
                        }
                    }
                }
            }
            return calcRange();

//        heap.add(new Element(pq.peek(), (Integer) pq.toArray()[pq.size()-1]));
//        int removed = pq.poll();
//        for (int i = 0; i < input.length; i++){
//            if (j[i]+1<input[i].length){
//                if (removed == input[i][j[i]]){
//                    j[i]++;
//                    pq.add(input[i][j[i]]);
//                }
//            }
//        }
//        return calcRange();
//        heap.add(new Element(pq.peek(), (Integer) pq.toArray()[pq.size()-1]));
////        while (!heap.isEmpty()){
//            Element rem = heap.remove();
//            System.out.print(rem.diff + " = " + rem.last + " - " + rem.first + ", ");
////        }
    }
}

class Element{
    int first;
    int last;
    int diff;
    Element(int first, int last){
        this.first = first;
        this.last = last;
        this.diff = last - first;
    }
}

class ElementComparator implements Comparator<Element>{
    public int compare(Element e1, Element e2){
        if (e2.diff < e1.diff) return 1;
        else if (e2.diff > e1.diff) return -1;
        return 0;
    }
}
