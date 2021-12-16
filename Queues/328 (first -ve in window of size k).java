package com.Nikunj.Queue.Q14;

import java.util.Deque;
import java.util.LinkedList;

public class FirstNegative {
    public static void main(String[] args) {
        int a[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = a.length;
        int k = 3;
        Deque<Integer> q = new LinkedList<>();
        int i;
        for (i = 0; i<k; i++){
            if (a[i] < 0){
                q.add(i);
            }
        }
        for (; i<n; i++){
            if (q.isEmpty()){
                System.out.print(0 + " ");
            }
            else {
                System.out.print(a[q.peek()] + " ");
            }
            while (!q.isEmpty() && q.peek()<=i-k){
                q.remove();
            }
            if (a[i] < 0){
                q.add(i);
            }
        }
        if (q.isEmpty()) System.out.print(0 + " ");
        else System.out.print(a[q.peek()]);
    }
}
