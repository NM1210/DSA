package com.Nikunj.Heaps.Q4;

import java.util.ArrayList;

class Node{
    int data;
    Node left, right;
    Node(int d){
        data = d;
        left = right = null;
    }
}

public class HeapOrNot {
    Node root;
    ArrayList<Node> heap = new ArrayList<>();
    int size = 0;

    public void convert(){
        heap.add(new Node(Integer.MIN_VALUE));
        int itr = 0;
        heap.add(root);
        itr++;
        while (itr<heap.size()){
            if (heap.get(itr)!=null){
                heap.add(heap.get(itr).left);
                heap.add(heap.get(itr).right);
            }
            itr++;
        }
    }

    public boolean isComplete(){
        int end = heap.size()-1;
        while (heap.get(end)==null){
            end--;
        }
        int beg = 0;
        while (beg!=end){
            if (heap.get(beg)==null){
                break;
            }
            beg++;
        }
        if (beg == end){
            size = end;
            return true;
        }
        else return false;
    }

    public boolean isHeap(){
        int f = 0;
        if (isComplete()){
//            System.out.println(size);
            for (int i = 1; i<=size/2; i++){
                if (heap.get(2*i+1)!=null){
                    if (!(heap.get(i).data > heap.get(2*i).data) || !(heap.get(i).data > heap.get(2*i+1).data)){
                        f = 1;
                    }
                }
            }
        }
        else f=1;
        if (f==0) return true;
        else return false;
    }

    public static void main(String[] args) {
        HeapOrNot Btree = new HeapOrNot();
        Btree.root = new Node(7);
        Btree.root.left = new Node(6);
        Btree.root.right = new Node(5);
        Btree.root.left.left = new Node(4);
        Btree.root.left.right = new Node(3);
        Btree.root.right.left = new Node(2);
        Btree.root.right.right = new Node(1);

        Btree.convert();
//        System.out.println(Btree.isComplete());
        System.out.print(Btree.isHeap());

//        for (int i = 0; i<Btree.heap.size(); i++){
//            if (Btree.heap.get(i)!=null){
//                System.out.print(Btree.heap.get(i).data + " ");
//            }
//            else System.out.print("null ");
//        }
    }
}
