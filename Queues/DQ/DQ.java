package com.Nikunj.Queue.DQ;

import java.util.Scanner;

public class DQ {
    static Scanner input = new Scanner(System.in);

    Node front;
    Node rear;

    class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            data = d;
            next = null;
            prev = null;
        }
    }

    public void enqueue(int d){
        Node p = new Node(d);
        if (front == null && rear == null){
            front = p;
            rear = p;
        }
        else {
            rear.next = p;
            p.prev = rear;
            rear = p;
        }
    }

    public int dequeue(){
        Node p = front;
        if (p == null){
            System.out.println("underflow");
            return Integer.MAX_VALUE;
        }
        else if (front == rear){
            front = null;
            rear = null;
            return p.data;
        }
        else{
            front = front.next;
            front.prev = null;
            p.next = null;
            return p.data;
        }
    }

    public void reverseEnqueue(int d){
        Node p = new Node(d);
        if (front == null && rear == null){
            front = p;
            rear = p;
        }
        else {
            p.next = front;
            front.prev = p;
            front = front.prev;
        }
    }

    public int reverseDequeue(){
        Node p = rear;
        if (p == null){
            System.out.println("underflow");
            return Integer.MAX_VALUE;
        }
        else if (front == rear){
            front = null;
            rear = null;
            return p.data;
        }
        else {
            rear = rear.prev;
            rear.next = null;
            p.prev = null;
            return p.data;
        }
    }

    public int size(){
        int size = 0;
        Node p = front;
        if (p==null) return 0;
        else {
            size = 1;
            while (p!=null){
                p = p.next;
                size++;
            }
            return size;
        }
    }

    public void print(){
        Node p = front;
        if (p == null) System.out.println("underflow");
        else {
            while (p!=null){
                System.out.print(p.data + " ");
                p = p.next;
            }
        }
    }

    public Node front(){
        return front;
    }

    public static void main(String[] args) {
//        DQ dq = new DQ();
//
//        dq.enqueue(input.nextInt());
//        dq.enqueue(input.nextInt());
//        dq.enqueue(input.nextInt());
//        dq.print();
//        System.out.println("\n" + dq.dequeue());
////        System.out.println(dq.dequeue());
////        System.out.println(dq.dequeue());
////        System.out.println(dq.dequeue());
//        dq.reverseEnqueue(input.nextInt());
//        dq.print();
//        System.out.println("\n" + dq.reverseDequeue());
//        dq.print();
//        System.out.println(dq.front()==null?"front = null":"front = "+ dq.front().data);
//        System.out.println("\n" + dq.dequeue());
//        System.out.println(dq.reverseDequeue());
//        System.out.println(dq.dequeue());
//        System.out.println(dq.reverseDequeue());
//        System.out.println(dq.front()==null?"front = null":"front = "+ dq.front().data);
    }
}
