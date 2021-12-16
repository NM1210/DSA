package com.Nikunj.Heaps.Q8;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MaxDistinct {
    int heap[];
    int size;
    int capacity;
    MaxDistinct(int n){
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

    public int find(int lim){
        if (lim==0) return size;
        int freq = extract();
        if (freq-1 != 0) insert(freq-1);
        return find(lim-1);
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int array[] = {5, 7, 5, 5, 1, 2, 2};
        int k = 3;
        for (int i = 0; i < array.length; i++){
            int count = 0;
            if (!map.containsKey(array[i])){
                map.put(array[i], count++);
                for (int j = i; j< array.length; j++){
                    if (array[j]==array[i]){
                        map.replace(array[i], count++);
                    }
                }
            }
        }
//        System.out.print(map.keySet() + " " + map.values() + " ");
        Object[] frequencies = map.values().toArray();
//        for (int i = 0; i< frequencies.length; i++){
//            System.out.print(frequencies[i] + " ");
//        }
        MaxDistinct maxHeap = new MaxDistinct(map.values().size());
        for (int i = 0; i< frequencies.length; i++){
            maxHeap.insert((Integer) frequencies[i]);
        }
        int ans = maxHeap.find(k);
//        for (int i = 0; i< maxHeap.size; i++){
//            System.out.print(maxHeap.heap[i] + " ");
//        }
        System.out.print("ans = " + ans);
//        System.out.print("size = " + maxHeap.size);
    }
}
