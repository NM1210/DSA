package com.Nikunj.Heap;

import java.util.Scanner;

public class MaxHeap {
    static Scanner input = new Scanner(System.in);

    private int[] heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[maxsize+1];
        heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos){
        return pos/2;
    }

    private int leftChild(int pos){
        return (2*pos);
    }

    private int rightChild(int pos){
        return (2*pos+1);
    }

    private boolean isLeaf(int pos){
        if (pos >= size/2 && pos <= size){
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos){
        int temp;
        temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    private void maxHeapify(int pos){
        if (isLeaf(pos)){
            return;
        }
        if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]){
            if (heap[leftChild(pos)] > heap[rightChild(pos)]){
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void insert(int element){
        heap[++size] = element;
        int curr = size;
        while (heap[curr] > heap[parent(curr)]){
            swap(curr,parent(curr));
            curr = parent(curr);
        }
    }

    public void print(){
        for (int i = 1; i <= size/2; i++){
            System.out.println("P = " + heap[i] + " LC = " + heap[2*i] + " RC " + heap[2*i+1]);
        }
    }

    public int extractMax(){
        if (size<1){
            return heap[0];
        }
        int popped = heap[1];
        heap[1] = heap[size];
        maxHeapify(1);
        size--;
        return popped;
    }

    public void insertHeap(int lim){
        while (size+1<=lim){
            heap[size+1] = input.nextInt();
            size++;
        }
    }

    public void printHeap(int lim){
        for (int i = 1; i <= lim; i++){
            System.out.print(heap[i]+" ");
        }
    }

    public void check(int pos){
        if (pos == 1) return;
        else if (heap[pos] > heap[parent(pos)]){
            swap(pos, parent(pos));
            check(parent(pos));
        }
        else return;
    }

    public void initHeapify(){
        for (int i = 1; i <=size; i++){
            check(i);
        }
    }

    public void sort(){
        if (size==1) return;
        int temp = heap[1];
        heap[1] = heap[size];
        heap[size] = temp;
        maxHeapify(1);
        size--;
        sort();
    }

    public int Largest(int k){
        if (k>size) return heap[0];
        if (k<=0) return heap[size+1];
        int temp = heap[1];
        heap[1] = heap[size];
        heap[size] = temp;
        maxHeapify(1);
        size--;
        return Largest(k-1);
    }

    public int kSmallest(int k, int n){
        if (k<=0 || k>n){
            return heap[0];
        }
        if (size==k-1) return heap[size+1];
        int temp = heap[1];
        heap[1] = heap[size];
        heap[size] = temp;
        maxHeapify(1);
        --size;
        return kSmallest(k,n);
    }

    public int kLargest(int k, int n){
        int l = n-k+1;
        if (l<=0 || l>n){
            return heap[0];
        }
        if (size==l-1) return heap[size+1];
        int temp = heap[1];
        heap[1] = heap[size];
        heap[size] = temp;
        maxHeapify(1);
        --size;
        return kLargest(k,n);
    }

    public void SmallestLargest(int k,int l, int n){
        if (k==l){
            if (size<k){
                System.out.print(k + " Smallest = " + heap[size+1]);
                System.out.print("\n" + k + " Largest = " + heap[size+1]);
                return;
            }
            int temp = heap[1];
            heap[1] = heap[size];
            heap[size] = temp;
            maxHeapify(1);
            size--;
            SmallestLargest(k, l, n);
        }
        if (k>l){
            if (size == k-1){
                System.out.print(k + " Smallest = " + heap[size+1]);
            }
            if (size<l){
                System.out.print("\n" + k + " Largest = " + heap[size+1]);
                return;
            }
            int temp = heap[1];
            heap[1] = heap[size];
            heap[size] = temp;
            maxHeapify(1);
            size--;
            SmallestLargest(k, l, n);
        }
        if (k<l){
            if (size == l-1){
                System.out.print(k + " Largest = " + heap[size+1]);
            }
            if (size<k){
                System.out.print("\n" + k + " Smallest = " + heap[size+1]);
                return;
            }
            int temp = heap[1];
            heap[1] = heap[size];
            heap[size] = temp;
            maxHeapify(1);
            size--;
            SmallestLargest(k, l, n);
        }
    }

    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
//        System.out.println("Max = " + maxHeap.extractMax());

//        System.out.println(maxHeap.kSmallest(3, maxHeap.size));
//        System.out.println(maxHeap.kLargest(3, maxHeap.size));
//        System.out.println(maxHeap.Smallest(3));
//        System.out.println(maxHeap.Largest(9));

//        int k = 9;
//        maxHeap.SmallestLargest(k, maxHeap.size - k + 1, maxHeap.size);

//        int kLargest = 0;
//        while (--k>0){
//            kLargest = maxHeap.extractMax();
//        }
//        if (k==0) System.out.println("kLargest = " + maxHeap.extractMax());

//        int lim = 9;
//        maxHeap.insertHeap(lim);
//        maxHeap.printHeap(lim);
//        maxHeap.initHeapify();
//        System.out.println();
//        maxHeap.printHeap(lim);
//        maxHeap.sort();
//        System.out.println();
//        maxHeap.printHeap(lim);

//        int a[] = {5, 3, 17, 10, 84, 19, 6, 22, 9};
//        int k = input.nextInt();
//        for (int i = 0; i + k <= a.length; i++){
//            MaxHeap maxHeap = new MaxHeap(k+1);
//            for (int j = i; j < k+i; j++){
//                maxHeap.insert(a[j]);
//            }
//            System.out.print(maxHeap.extractMax()+" ");
//        }
    }
}
