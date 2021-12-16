package com.Nikunj.Heaps.Q18;

import java.util.PriorityQueue;

public class SmallestSum {
    static PriorityQueue<Integer> heap = new PriorityQueue<>();

    public int findSum(int a, int b){
        if (heap.isEmpty()) return (a+b);
        else if (heap.size()%2==0){
            a = a * 10 + heap.peek();
        }
        else {
            b = b * 10 + heap.peek();
        }
        heap.remove();
        return findSum(a, b);
    }

    public static void main(String[] args) {
        SmallestSum sum = new SmallestSum();
        int input[] = {5, 3, 0, 7, 4};
        for (int i = 0; i< input.length; i++){
            heap.add(input[i]);
        }
        System.out.print(sum.findSum(0,0));
    }
}
