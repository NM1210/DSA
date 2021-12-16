package com.Nikunj.Heaps.Q10;

public class LargestTripletProduct {
    int heap[];
    int size;
    int capacity;
    LargestTripletProduct(int n){
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

    public int product(){
        int a = extract();
        int b = extract();
        int c = extract();
        int prod = a * b * c;
        insert(a);
        insert(b);
        insert(c);
        return prod;
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6};
        LargestTripletProduct maxHeap = new LargestTripletProduct(array.length);
        for (int i = 0; i<array.length; i++){
            maxHeap.insert(array[i]);
            if (maxHeap.size<3){
                System.out.print(-1 + " ");
            }
            else {
                System.out.print(maxHeap.product() + " ");
            }
        }
    }
}
