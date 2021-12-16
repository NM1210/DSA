package com.Nikunj.Heaps.Min;

import java.util.ArrayList;

public class MinHeap {
    private int[] heap;
    private int size;
    private int maxsize;

    public MinHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[maxsize+1];
        heap[0] = Integer.MIN_VALUE;
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

    private void minHeapify(int pos){
        if (isLeaf(pos)){
            return;
        }
        if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]){
            if (heap[leftChild(pos)] < heap[rightChild(pos)]){
                swap(pos, leftChild(pos));
                minHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                minHeapify(rightChild(pos));
            }
        }
    }

    public void insert(int element){
        if (size>=maxsize) return;
        heap[++size] = element;
        int curr = size;
        while (heap[curr] < heap[parent(curr)]){
            swap(curr,parent(curr));
            curr = parent(curr);
        }
    }

    public void print(){
        for (int i = 1; i <= size/2; i++){
            System.out.println("P = " + heap[i] + " LC = " + heap[2*i] + " RC " + heap[2*i+1]);
        }
    }

    public int extractMin(){
        int popped = heap[1];
        heap[1] = heap[size];
        heap[size] = Integer.MAX_VALUE;
        minHeapify(1);
        size--;
        return popped;
    }

    public int calc(int cost){
        if (size==2) {
            int a = extractMin();
            System.out.println("a = " + a);
            int b = extractMin();
            System.out.println("b = " + b);
            cost = cost + (a + b);
            System.out.println("cost = " + cost);
            insert(a+b);
            System.out.println("element = " + heap[1]);
            return cost;
        }
        int a = extractMin();
        System.out.println("a = " + a);
        int b = extractMin();
        System.out.println("b = " + b);
        cost = cost + (a + b);
        System.out.println("cost = " + cost);
        insert(a+b);
        System.out.println("element = " + heap[1]);
        return calc(cost);
    }

    static int matrix[][] = {{1,8,9,16},
                            {2,7,10,15},
                            {3,6,11,14},
                            {4,5,12,13}};
    static int j[] = new int[matrix.length];

    static ArrayList<Integer> output = new ArrayList<>();

    public void generateOP(){
        if (size<=0) return;
        int element = extractMin();
        output.add(element);
        for (int i = 0; i< matrix.length; i++){
            if (matrix[i][j[i]] == element){
                if (j[i]+1 < matrix[i].length){
                    j[i]++;
                    insert(matrix[i][j[i]]);
                }
            }
        }
        generateOP();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);

        for (int i = 0; i< matrix.length; i++){
            minHeap.insert(matrix[i][j[i]]);
        }
        minHeap.generateOP();
        for (int i = 0; i<output.size(); i++){
            System.out.print(output.get(i) + " ");
        }

//        int a[] = {4, 3, 2, 6};
//        for (int i = 0; i<a.length; i++){
//            minHeap.insert(a[i]);
//        }
//        minHeap.print();
//        System.out.println(minHeap.calc(0));
//        minHeap.insert(5);
//        minHeap.insert(3);
//        minHeap.insert(17);
//        minHeap.insert(10);
//        minHeap.insert(84);
//        minHeap.insert(19);
//        minHeap.insert(6);
//        minHeap.insert(22);
//        minHeap.insert(9);
//        System.out.println("Min = " + minHeap.extractMin());

    }
}
