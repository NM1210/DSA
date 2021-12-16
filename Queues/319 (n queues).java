package com.Nikunj.Queue.Q3;

public class kQueues {
    int n;
    int k;
    int a[];
    int front[];
    int rear[];
    int next[];
    int free;

    kQueues(int n, int k){
        this.n = n;
        this.k = k;
        this.a = new int[n];
        this.front = new int[k];
        this.rear = new int[k];
        this.next = new int[n];
        for (int i = 0; i < k; i++){
            front[i] = rear[i] = -1;
        }
        free = 0;
        for (int i = 0; i < n-1; i++){
            next[i] = i+1;
        }
        next[n-1] = -1;
    }

    public boolean isFull(int qn){
        return free == -1;
    }

    public boolean isEmpty(int qn){
        return front[qn] == -1;
    }

    public void enqueue(int element, int qn){
        if (isFull(qn)){
            System.out.println("Overflow");
            return;
        }
        int i = free;
        free = next[i];
        if (isEmpty(qn)){
            front[qn] = i;
        }
        else {
            next[rear[qn]] = i;
        }
        next[i] = -1;
        rear[qn] = i;
        a[i]=element;
    }

    public int dequeue(int qn){
        if (isEmpty(qn)){
            System.out.println("Underflow");
            return Integer.MAX_VALUE;
        }
        int i = front[qn];
        front[qn] = next[i];
        next[i] = free;
        free = i;
        return a[i];
    }

    public static void main(String[] args) {
        int n = 10, k = 3;
        kQueues qn = new kQueues(n, k);

        qn.enqueue(12, 0);

        qn.enqueue(13, 1);
        qn.enqueue(14, 1);
        qn.enqueue(15, 1);

        qn.enqueue(16, 2);

        System.out.println(qn.dequeue(2));
        System.out.println(qn.dequeue(1));
        System.out.println(qn.dequeue(0));
    }
}
