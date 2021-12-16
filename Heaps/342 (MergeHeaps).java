package com.Nikunj.Heaps.Q12;

public class MergeHeaps {
    int[] heap;
    int size;
    int capacity;
    MergeHeaps(int n){
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

    public static void main(String[] args) {
        int[] heap1 = {10, 5, 6, 2};
        int[] heap2 = {12, 7, 9};
        MergeHeaps maxHeap = new MergeHeaps(heap1.length+ heap2.length);
        for (int i = 0; i< heap1.length; i++){
            maxHeap.insert(heap1[i]);
        }
        for (int i = 0; i< heap2.length; i++){
            maxHeap.insert(heap2[i]);
        }
        for (int i = 0; i< maxHeap.size; i++){
            System.out.print(maxHeap.heap[i] + " ");
        }
    }
}
