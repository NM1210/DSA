package com.Nikunj.Stacks.Q6;

import java.util.Stack;

public class Q6 {
    Stack<Integer> s;

    Q6(){
        s = new Stack<>();
    }

    public void nextGreater(int element){
        if (s.isEmpty()){
            s.push(element);
        }
        else {
            while (!s.isEmpty() && element > s.peek()){
                System.out.println(s.pop() + " " + element);
//                s.push(element);
            }
            s.push(element);
        }
    }

    public static void main(String[] args) {
        Q6 stack = new Q6();

        int a[] = {4, 5, 2, 25};
        for (int i = 0; i < a.length; i++){
            stack.nextGreater(a[i]);
        }
        System.out.print(stack.s.pop() + " " + -1);

    }
}
