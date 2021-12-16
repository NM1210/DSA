package com.Nikunj.Stacks.Q1;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q1 {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    public void push1(int element){
        q2.add(element);
        while (!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop1(){
        return q1.remove();
    }

    public void print(){
        Iterator<Integer> iterator = q1.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }

    public static void main(String[] args) {
        Q1 stack = new Q1();

        stack.push1(12);
        stack.push1(13);
        stack.push1(23);
        stack.push1(42);
        stack.print();
        System.out.print(stack.pop1());
        System.out.print(stack.pop1());
        System.out.print(stack.pop1());
        System.out.print(stack.pop1());
//        System.out.print(stack.pop1());
    }
}
