package com.Nikunj.Queue.DQ;

public class Dequeue {
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

    public void insert(int d){
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

    public int removeFirst(){
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

    public void printQueue() {
        Node p = front;
        if (p == null) System.out.println("underflow");
        else {
            while (p != null) {
                System.out.print(p.data + " ");
                p = p.next;
            }
        }
    }

    public void printStack(){
        Node p = rear;
        if (rear==null) System.out.print("underflow");
        else {
            while (p!=null){
                System.out.print(p.data + " ");
                p = p.prev;
            }
        }
    }
}
class Stack extends Dequeue{
    public void push(int element){
        insert(element);
    }
    public int  pop(){
        return reverseDequeue();
    }
    public void print(){
        printStack();
    }
}
class Queue extends Dequeue{
    public void enqueue(int element){
        insert(element);
    }
    public int dequeue(){
        return removeFirst();
    }
    public void print(){
        printQueue();
    }
}
class TestRun{
    public static void main(String[] args) {
       Stack stack = new Stack();

       stack.push(19);
       stack.push(90);
       stack.push(31);
       stack.print();
       System.out.print(stack.pop());
       stack.print();

       Queue queue = new Queue();

       queue.enqueue(13);
       queue.enqueue(23);
       queue.enqueue(31);
       queue.print();
       System.out.print(queue.dequeue());
       queue.print();

    }
}