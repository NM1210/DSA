package com.Nikunj.Queue.Q7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class kReverse {
    static Queue<Integer> queue = new LinkedList<>();
    static int count = 0;
    static Queue<Integer> temp = new LinkedList<>();

    static Queue reverse(Queue<Integer> q){
        if (count>=2) return q;
        int front = (q.remove());
        count++;
        reverse(q);
        temp.add(front);
        return q;
    }

    public static void main(String[] args) {

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        Iterator<Integer> itr1 = queue.iterator();
        while (itr1.hasNext()){
            System.out.print(itr1.next() + " ");
        }
        System.out.println();
        reverse(queue);
        while (!queue.isEmpty()){
            temp.add(queue.remove());
        }
        Iterator<Integer> itr2 = temp.iterator();
        while (itr2.hasNext()){
            System.out.print(itr2.next() + " ");
        }
    }
}
