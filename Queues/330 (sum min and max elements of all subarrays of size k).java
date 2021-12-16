package com.Nikunj.Queue.Q16;

import java.util.Deque;
import java.util.LinkedList;

public class MinMaxSum {
    public static void main(String[] args) {
        int a[] = {2, 5, -1, 7, -3, -1, -2};
        int n = a.length;
        int k = 4;
        int sum = 0;
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        int i;
        for (i = 0; i<k; i++){
            while (!max.isEmpty() && a[i] >= a[max.peekLast()]){
                max.removeLast();
            }
            max.add(i);
            while (!min.isEmpty() && a[i] <= a[min.peekLast()]){
                min.removeLast();
            }
            min.add(i);
        }
        for (; i<n; i++){
            sum = sum + (a[max.peek()] +a[min.peek()]);
            while (!max.isEmpty() && max.peek()<=i-k){
                max.remove();
            }
            while (!min.isEmpty() && min.peek()<=i-k){
                min.remove();
            }
            while (!max.isEmpty() && a[i]>a[max.peekLast()]){
                max.removeLast();
            }
            while (!min.isEmpty() && a[i]<a[min.peekLast()]){
                min.removeLast();
            }
            max.add(i);
            min.add(i);
        }
        sum = sum + (a[max.peek()] +a[min.peek()]);
        System.out.print(sum);
    }
}
