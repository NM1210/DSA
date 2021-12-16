package com.Nikunj.Queue.Q;

import java.util.Scanner;

public class Q {

    static Scanner input = new Scanner(System.in);

    Node front;
    Node rear;

    class Node{
        Node next;
        int data;
        Node(int d){
            data = d;
            next = null;
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
            rear = p;
        }
    }

    public int dequeue(){
        System.out.println();
        Node p = front;
        if (front == null && rear == null){
            return Integer.MAX_VALUE;
        }
        else if (front == rear){
            front = null;
            rear = null;
            return p.data;
        }
        else {
            front = front.next;
            p.next = null;
            return p.data;
        }
    }

    public Node front(){
        return front;
    }

    public void display(){
        Node p = front;
        if (front == null && rear == null) {
            System.out.println();
            System.out.println("no elements to display");
        }
        else if (front == rear){
            System.out.print(p.data);
        }
        else {
            while (p!=null){
                System.out.print(p.data + " ");
                p = p.next;
            }
        }
//        System.out.println();
    }

    public static void main(String[] args) {
        Q queue = new Q();

        queue.enqueue(input.nextInt());
        queue.enqueue(input.nextInt());
        queue.enqueue(input.nextInt());
        queue.display();
        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
        queue.display();
        System.out.println(queue.front==null?"\0":queue.front());
    }
}
