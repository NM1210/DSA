package com.Nikunj.Queue.Q;

import java.util.Scanner;

public class NewQ {
    static Scanner input = new Scanner(System.in);

    int front, rear;
    int size;
    int maxsize;
    int array[];

    NewQ(int maxsize){
        this.maxsize = maxsize;
        front = -1;
        rear = -1;
        this.size = 0;
        array = new int[this.maxsize];
    }

    public void enqueue(int element){
        if (rear==size-1){
//            rear--;
            System.out.println("overflow");
        }
        else if (front==-1&&rear==-1){
            ++front;
            array[++rear] = element;
        }
        else {
            array[++rear] = element;
        }
    }

    public int dequeue(){
        if (front==-1&&rear==-1){
            System.out.print("\nunderflow no elements left to be deleted");
            return Integer.MAX_VALUE;
        }
        else {
            return array[front++];
        }
    }

    public void print(){
        int p = front;
        if (p==-1||p>rear) System.out.print("\nunderflow no elements to print");
        else {
            while (p<=rear){
                System.out.print(array[p++] + " ");
            }
        }
    }

    public boolean search(int element){
        int f = 0;
        int p = front;
        if (p==-1||p>rear) f = 0;
        else {
            while (p<=rear){
                if (array[p++] == element){
                    f = 1;
                }
            }
        }
        if (f==1) return true;
        return false;
    }

    public void empty(){
        if (front==-1&&rear==-1||front>rear) System.out.print("\nunderflow already empty");
        else {
            front=-1;
            rear=-1;
        }
    }

    public static void main(String[] args) {
        NewQ q = new NewQ(20);

        System.out.println("Enter the size of the queue");
        q.size = input.nextInt();

        q.enqueue(input.nextInt());
        q.enqueue(input.nextInt());
//        q.enqueue(input.nextInt());
        q.enqueue(input.nextInt());
        q.enqueue(input.nextInt());

        q.print();
//        q.empty();
//        q.print();
//        System.out.print("\n"+q.search(2));
//        System.out.print("\n"+q.search(4));
//        System.out.println("\n"+q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.print(q.dequeue());
//        q.print();
//        q.empty();
//        q.print();
//        System.out.print("\n"+q.search(2));
//        System.out.println("\n"+q.search(4));
//        q.print();
    }
}
