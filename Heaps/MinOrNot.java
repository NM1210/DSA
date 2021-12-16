package com.Nikunj.Heaps.Q16;

public class MinOrNot {
    int[] heap;
    int size;
    MinOrNot(int[] array){
        heap = array;
        size = array.length;
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
    public boolean check(){
        int f = 0;
        for (int i = 0; i<=(size-1)/2; i++){
            if (left(i)<size && right(i)<size){
                if (heap[i] > heap[left(i)] || heap[i] > heap[right(i)]){
                    f = 1;
                }
            }
        }
        if (f==0) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] levelOrder = {30, 56, 22, 49, 30, 51, 2, 67};
        MinOrNot minHeap = new MinOrNot(levelOrder);
        System.out.print(minHeap.check());
    }
}
