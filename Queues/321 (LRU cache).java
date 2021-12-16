package com.Nikunj.Queue.Q2;

import java.util.LinkedList;
import java.util.Queue;

public class LRUcache {
    public static void main(String[] args) {
        Queue<Integer> cache = new LinkedList<>();
        int[] a = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int k = 3, j = 0;
        for (int i = 0; i < a.length; i++){
            if (j<k){
                cache.add(a[i]);
                j++;
            }
            else {
                if (cache.contains(a[i])){
                    Queue<Integer> temp = new LinkedList<>();
                    for (Integer element : cache){
                        if (element!=a[i]){
                            temp.add(element);
                        }
                    }
                    temp.add(a[i]);
                    cache = temp;
                }
                else {
                    cache.remove();
                    cache.add(a[i]);
                }
            }
            for (Integer element : cache){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
