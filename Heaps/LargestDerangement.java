package com.Nikunj.Heaps.Q7;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestDerangement {
    HashMap<Integer, Integer> map = new HashMap<>();
//    int ans[];
    int heap[];
    int size;
    int capacity;
    LargestDerangement(int n){
//        this.ans = new int[n];
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
        int largest = i;
        int l = left(i);
        int r = right(i);
        if (l<size && heap[l]>heap[largest]){
            largest = l;
        }
        if (r<size && heap[r]>heap[largest]){
            largest = r;
        }
        if (i == largest) return;
        swap(i,largest);
        heapify(largest);
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
        while (heap[parent(i)]<heap[i]){
            heapify(parent(i));
            i = parent(i);
        }
    }

    public int[] derange(int[] ans, int[] array, int prev){
        if (size<=0){
//            System.out.print("final = " );
//            for (int i = 0; i<ans.length;i++){
//                System.out.print(ans[i] + " ");
//            }
            return ans;
        }
        else {
//            for (int i = 0; i<ans.length;i++){
//                System.out.print(ans[i] + " ");
//            }
            int element = extract();
//        System.out.print(map.get(element)+" ");
            for (int i = 0; i < array.length; i++){
                if (element != array[i] && ans[i] == 0){
                    ans[i] = element;
                    ans = derange(ans, array, i);
//                ans[i] = 0;
                }
            }
            int f = 0;
            for (int i = 0; i< ans.length; i++){
                if (ans[i] == 0) f = 1;
            }
            if (f == 1){
                insert(element);
                if (element == array[array.length-1]){
                    ans[prev]=0;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int array[] = {5, 4, 3, 2, 1};
        int ans[] = new int[array.length];
//        ArrayList<Integer> ans = new ArrayList<>();
        LargestDerangement maxHeap = new LargestDerangement(array.length);
        for (int i = 0; i< array.length; i++){
            maxHeap.insert(array[i]);
            maxHeap.map.put(array[i], i);
        }
//        System.out.print(maxHeap.ans.length);
        ans = maxHeap.derange(ans, array, 0);
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }

//        System.out.print(maxHeap.map.keySet() + " " + maxHeap.map.values());

//        for (int i = 0; i < array.length; i++){
//            System.out.print(maxHeap.heap[i] + " ");
//        }
//        System.out.println();
//        System.out.println(maxHeap.extract());
//        maxHeap.insert(6);
//        System.out.println(maxHeap.extract());
//        maxHeap.insert(8);
//        for (int i = 0; i< maxHeap.size; i++){
//            System.out.print(maxHeap.heap[i] + " ");
//        }
    }
}
