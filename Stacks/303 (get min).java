package com.Nikunj.Stacks.Q3;

import java.util.Stack;

public class Q3 {

    Stack<Integer> temp;
    Integer min;

    Q3(){
        temp = new Stack<>();
    }

    public void push(int element){
        if (temp.isEmpty()){
            min = element;
            temp.push(element);
        }
        if (element<min){
            temp.push(2*element-min);
            min = element;
        }
        else {
            temp.push(element);
        }
    }

    public void pop(){
        if (temp.isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        Integer curr = temp.pop();
        if (curr<min){
            System.out.println(min);
            min = 2*min-curr;
        }
        else System.out.println(curr);
    }

    void getMin() {
        if (temp.isEmpty())
            System.out.println("Stack is empty");

        else
            System.out.println("Minimum Element in the " +
                    " stack is: " + min);
    }
//    Stack<Integer> stack;
//    Stack<Integer> temp;
//
//    Q3(){
//        stack = new Stack<>();
//        temp = new Stack<>();
//    }
//
//    public void insert(int element){
//        if (stack.isEmpty()){
//            stack.push(element);
//        }
//        else {
//            while (!stack.isEmpty() && element > stack.peek()){
//                temp.push(stack.pop());
//            }
//            stack.push(element);
//            while (!temp.empty()){
//                stack.push(temp.pop());
//            }
//        }
//    }
//
//    public int getMin(){
//        return stack.peek();
//    }

    public static void main(String[] args) {

        Q3 stack = new Q3();
        stack.push(3);
        stack.push(5);
        stack.getMin();
        stack.push(2);
        stack.push(1);
        stack.getMin();
        stack.pop();
        stack.getMin();
        stack.pop();

//        Q3 stack = new Q3();
//        stack.insert(18);
//        stack.insert(19);
//        stack.insert(29);
//        stack.insert(15);
//        stack.insert(16);
//        System.out.println(stack.getMin());
//        while (!stack.stack.isEmpty()){
//            System.out.print(stack.stack.pop() + " ");
//        }

    }
}
