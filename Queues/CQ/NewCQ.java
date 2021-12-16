package com.Nikunj.Queue.CQ;

import java.util.Scanner;

public class NewCQ {
    static Scanner input = new Scanner(System.in);

    int front;
    int rear;
    int maxsize;
    int size;
    int a[];
    NewCQ(int maxsize){
        this.maxsize = maxsize;
        front = -1;
        rear = -1;
        this.size = 0;
        a = new int[this.maxsize];
    }

    public void enqueue(int element){
        if (rear==-1&&front==-1){
            front = (front+1)%size;
            rear = (rear+1)%size;
            a[rear] = element;
            rear = ((rear+1)%size);
        }
        else if (rear == front){
            System.out.print("overflow");
        }
        else if (rear != front){
            a[rear] = element;
            rear = (rear+1)%size;
        }
    }

    public void print(){
        int p = front;
        if (p == -1) System.out.print("underflow");
        else if (rear == front){
            int i = 0;
            while (i<size){
                System.out.print(a[p] + " ");
                p = (p+1)%size;
                i++;
            }
        }
        else {
            while (p!=rear){
                System.out.print(a[p] + " ");
                p = (p+1)%size;
            }
        }
    }

    public int dequeue(){
        int p = front;
        if (p==front&&p==rear&&p!=-1){
            front = -1;
            rear = -1;
            return a[p];
        }
        else if (p==-1){
            System.out.print("underflow");
            return Integer.MIN_VALUE;
        }
        else {
            front = (front+1)%maxsize;
            return a[p];
        }
    }

    public static void main(String[] args) {
        NewCQ cq = new NewCQ(15);

        System.out.print("size = ");
        cq.size = input.nextInt();

        cq.enqueue(input.nextInt());
        cq.enqueue(input.nextInt());
        cq.enqueue(input.nextInt());
//        cq.enqueue(input.nextInt());
//        System.out.println(cq.front + " " + cq.rear);
        cq.print();
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
        cq.print();
    }
}
