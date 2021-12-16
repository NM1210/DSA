package com.Nikunj.Stack;

import java.util.Scanner;

public class NewStack {
    static Scanner input = new Scanner(System.in);

    int top, capacity;
    int array[];

    public NewStack(int capacity){
        this.capacity = capacity;
//        this.size = 0;
        top = -1;
        array = new int[this.capacity];
    }

    public void push(int element){
        if (top == capacity) System.out.println("overflow");
        else if (top == -1) array[++top] = element;
        else array[++top] = element;
    }

    public int pop(){
        if (top == -1){
            System.out.print("\nunderflow cannot perform deletion");
            return Integer.MIN_VALUE;
        }
        else return array[top--];
    }

    public void print(){
        int p = top;
        if (p == -1) System.out.print("\nunderflow cannot print");
        else {
            while (p >= 0){
                System.out.print(array[p--] + " ");
            }
        }
    }

    public boolean search(int element){
        if (top == -1){
            System.out.print("\nunderflow no elements present to search");
            return false;
        }
        else {
            int p = top;
            while (p >= 0){
                if (array[p--] == element) return true;
            }
        }
        return false;
    }

    public void empty(){
        if (top == -1) {
            System.out.print("\nunderflow already empty");
        }
        else top = -1;
    }

    public static void main(String[] args) {
        System.out.println("enter the size ");
        int n = input.nextInt();
        NewStack stack = new NewStack(n);
        for (int i = 0; i < n; i++){
            stack.push(input.nextInt());
        }
        stack.print();
        System.out.print("\n" + stack.search(4));
//        stack.empty();
//        System.out.print("\n" + stack.pop());
//        System.out.print("\n" + stack.pop());
//        System.out.print("\n" + stack.pop());
//        stack.print();
//        System.out.print("\n" + stack.pop());
//        stack.empty();
    }
}
