package com.Nikunj.Stack;

import java.util.Scanner;

public class Stack {
    static Scanner input = new Scanner(System.in);

    Node top;

    class Node{
        Node next;
        int data;
        char ch;
        Node(int d){
            data = d;
            ch = 0;
            next = null;
        }
        Node(char c){
            data = 0;
            ch = c;
            next = null;
        }
    }

    void push(int d){
        Node p = new Node(d);
        if (top == null){
            top = p;
        }
        else {
            p.next = top;
            top = p;
        }
    }

    void pushChar(char c){
        Node p = new Node(c);
        if (top == null){
            top = p;
        }
        else {
            p.next = top;
            top = p;
        }
    }

    public void print(){
        if (top == null) System.out.println("null");
        else{
            Node p = top;
            while (p != null){
                System.out.print(p.data + " ");
                p = p.next;
            }
            System.out.println();
        }
    }

    public int pop(){
        Node p = top;
        if (top == null) {
            System.out.println("stack empty no more popping");
            return 0;
        }
        else if (top.next==null){
            top = null;
            return p.data;
        }
        else {
            top = top.next;
            p.next = null;
            return p.data;
        }
    }

    public char popChar(){
        Node p = top;
        if (top == null) {
            System.out.println("stack empty no more popping");
            return p.ch;
        }
        else if (top.next==null){
            top = null;
            return p.ch;
        }
        else {
            top = top.next;
            p.next = null;
            return p.ch;
        }
    }

    public void empty(){
        while (top!=null){
            Node p = top;
            top = top.next;
            p.next = null;
        }
    }

    public boolean search(int element){
        int f = 0;
        if (top == null) {}
        else {
            Node p = top;
            while (p.next!=null){
                if (p.data==element) f = 1;
                p = p.next;
            }
        }
        if (f == 1) return true;
        else return false;
    }

    public String reverse(String str){
        String rev = "";
        for (int i = 0; i < str.length(); i++){
            pushChar(str.charAt(i));
        }
        while (top!=null){
            rev = rev.concat(String.valueOf(popChar()));
        }
        return rev;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

//        stack.push(input.nextInt());
//        stack.push(input.nextInt());
//        stack.push(input.nextInt());
//        System.out.println(stack.pop() + " popped");
//        System.out.println(stack.pop() + " popped");
//        stack.print();
//        stack.empty();
//        stack.print();
//        System.out.println(stack.search(2));

//        System.out.println(stack.reverse(input.nextLine()));

    }
}
