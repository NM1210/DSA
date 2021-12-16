package com.Nikunj.Queue.Q6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Reverse {
    static Queue<Integer> queue = new LinkedList<>();
//    static Queue<Integer> temp = new LinkedList<>();

    static Queue reverse(Queue<Integer> q){
        if (q.size()==1) return q;
        int front = q.remove();
        Queue<Integer> temp = reverse(q);
        q.add(front);
        return q;
    }

    public static void main(String[] args) {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        Iterator<Integer> itr1 = queue.iterator();
        while (itr1.hasNext()){
            System.out.print(itr1.next() + " ");
        }
        System.out.println();
        reverse(queue);
        Iterator<Integer> itr2 = queue.iterator();
        while (itr2.hasNext()){
            System.out.print(itr2.next() + " ");
        }
    }
}
