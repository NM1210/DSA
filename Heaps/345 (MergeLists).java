package com.Nikunj.Heaps.Q20;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeLists {
    Queue<Integer> heap = new PriorityQueue<>();

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();
        list1.add(1); list2.add(2); list3.add(0);
        list1.add(3); list2.add(4); list3.add(9);
        list1.add(5); list2.add(6); list3.add(10);
        list1.add(7); list2.add(8); list3.add(11);
        MergeLists minHeap = new MergeLists();
        for (int i = 0; i < list1.size(); i++){
            minHeap.heap.add(list1.get(i));
            minHeap.heap.add(list2.get(i));
            minHeap.heap.add(list3.get(i));
        }
//        System.out.print(minHeap.heap);
        LinkedList<Integer> ans = new LinkedList<>();
        while (!minHeap.heap.isEmpty()){
            ans.add(minHeap.heap.remove());
        }
        for (int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + "->");
        }
    }
}
