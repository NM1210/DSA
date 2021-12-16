package com.Nikunj.Stacks.Q2;

public class Q2 {
    int a[];
    int top[];
    int next[];
    int n,k,free;

    Q2(int n1, int k1){
        n = n1;
        k = k1;
        free = 0;
        a = new int[n];
        top = new int[k];
        next = new int[n];
        for (int i = 0; i < n-1; i++){
            next[i] = i+1;
        }
        next[n-1] = -1;
        for (int i = 0; i < k; i++){
            top[i] = -1;
        }
    }

    public boolean isFull(){
        return (free == -1);
    }

    public boolean isEmpty(int sn){
        return (top[sn] == -1);
    }

    public void push(int element, int sn){
        if (isFull()){
            System.out.println("overflow");
            return;
        }
        int i = free;
        free = next[i];
        next[i] = top[sn];
        top[sn] = i;
        a[free] = element;
    }

    public int pop(int sn){
        if (isEmpty(sn)){
            System.out.println("underflow");
            return Integer.MAX_VALUE;
        }
        int i = top[sn];
        top[sn] = next[i];
        next[i] = free;
        free = i;
        return a[i];
    }

    public static void main(String[] args) {
        Q2 stack = new Q2(9,3);

        stack.push(15, 2);
        stack.push(45, 2);

        stack.push(17, 1);
        stack.push(49, 1);
        stack.push(39, 1);

        stack.push(11, 0);
        stack.push(9, 0);
        stack.push(7, 0);

        System.out.println("Popped element from stack 2 is " + stack.pop(2));
        System.out.println("Popped element from stack 1 is " + stack.pop(1));
        System.out.println("Popped element from stack 0 is " + stack.pop(0));
    }
}
