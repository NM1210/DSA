package com.Nikunj.Heaps.Q14;

public class MinToMax {
    int[] heap;
    int size;
    MinToMax(int[] array){
        heap = array;
        size = array.length;
        int i = (size-1)/2;
        while (i>-1){
            heapify(i);
            i--;
        }
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

    public static void main(String[] args) {
        int[] min = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        for (int i = 0; i< min.length; i++){
            System.out.print(min[i] + " ");
        }
        MinToMax maxHeap = new MinToMax(min);
        System.out.println();
        for (int i = 0; i< min.length; i++){
            System.out.print(min[i] + " ");
        }
    }
}
