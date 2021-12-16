package com.Nikunj.Stacks.Q10;

import java.util.Stack;

public class Q10 {

    Stack<Integer> s;

    Q10(){
        s = new Stack<>();
    }

    public void insertBottom(int element){
        if (s.isEmpty()){
            s.push(element);
        }
        else {
            int top = s.pop();
            insertBottom(element);
            s.push(top);
        }
    }

    public void reverse(){
        if (s.isEmpty()){
            return;
        }
        else {
            int top = s.pop();
            reverse();
            insertBottom(top);
        }
    }

    public void stackEmpty(){
        if (s.isEmpty()){
            return;
        }
        else {
            int top = s.pop();
            stackEmpty();
            stackInsert(top);
        }
    }

    public void stackInsert(int element){
//        if (s.isEmpty()) return;
//        else {
            if (s.isEmpty()){
                s.push(element);
            }
            else if (element>s.peek()){
                s.push(element);
            }
            else {
                int top = s.pop();
                stackInsert(element);
                s.push(top);
            }
//        }
    }

    public static void main(String[] args) {
        Q10 stack = new Q10();

        stack.s.push(-5);
        stack.s.push(18);
        stack.s.push(14);
        stack.s.push(-3);
//        while (!stack.s.isEmpty()){
//            System.out.print(stack.s.pop()+" ");
//        }
        stack.insertBottom(30);
        while (!stack.s.isEmpty()){
            System.out.print(stack.s.pop()+" ");
        }
        System.out.println();
        stack.s.push(-5);
        stack.s.push(18);
        stack.s.push(14);
        stack.s.push(-3);
        stack.insertBottom(30);
        stack.reverse();
        while (!stack.s.isEmpty()){
            System.out.print(stack.s.pop()+" ");
        }
        System.out.println();
        stack.s.push(-5);
        stack.s.push(18);
        stack.s.push(14);
        stack.s.push(-3);
        stack.insertBottom(30);
        stack.reverse();
        stack.reverse();
        stack.stackEmpty();
        while (!stack.s.isEmpty()){
            System.out.print(stack.s.pop()+" ");
        }
    }
}
