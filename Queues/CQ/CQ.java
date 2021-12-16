package com.Nikunj.Queue.CQ;

import java.util.Scanner;

public class CQ {
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
            rear.next = front;
        }
        else {
            rear.next = p;
            rear = p;
            rear.next = front;
        }
    }

    public int dequeue(){
        Node p = front;
        if (front == null && rear == null){
            System.out.println("CQ already empty");
            int i = Integer.MAX_VALUE;
            return i;
        }
        else if (front == rear){
            front = null;
            rear = null;
            return p.data;
        }
        else {
            front = front.next;
            p.next = null;
            rear.next = front;
            return p.data;
        }
    }

    public void display(){
        if (front == null && rear == null){
            System.out.println("CQ empty cannot be displayed");
        }
        else {
            Node p = front;
            int f = 0;
            while (p!=front || f==0){
                System.out.print(p.data + " ");
                p = p.next;
                f++;
            }
        }
    }

    public Node front(){
        return front;
    }

    public static void main(String[] args) {
        CQ cq = new CQ();

        cq.enqueue(input.nextInt());
        cq.enqueue(input.nextInt());
        cq.enqueue(input.nextInt());
        cq.display();
        System.out.println("\n" + cq.dequeue());
        System.out.println(cq.dequeue());
//        System.out.println(cq.dequeue());
//        System.out.println(cq.dequeue());
        cq.display();
        System.out.println("\n"+(cq.front == null?"front = \0":cq.front().data));
    }
}
