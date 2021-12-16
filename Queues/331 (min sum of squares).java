package com.Nikunj.Queue.Q17;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinSumSq {
    public static void main(String[] args) {
        String input = "aabaabccb";
        int k = 4;
        double ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer lhs, Integer rhs) {
                if(lhs<rhs) return +1;
                if(lhs>rhs) return -1;
                return 0;
            }
        });
        for (int i = 0; i<input.length(); i++){
            int count = 0;
            if (!input.substring(0,i).contains(String.valueOf(input.charAt(i)))){
                for (int j = i; j<input.length(); j++){
                    if (input.charAt(j) == input.charAt(i)){
                        count++;
                    }
                }
                q.add(count);
            }
        }
        while (k!=0){
            q.add(q.remove()-1);
            k--;
        }
//        while (!q.isEmpty()){
//            System.out.print(q.remove() + " ");
//        }
        while (!q.isEmpty()){
            ans = ans + Math.pow(q.remove(), 2);
        }
        System.out.print(ans);
//        while (!q.isEmpty()){
//            System.out.print(q.remove() + " ");
//        }
    }
}
