package com.Nikunj.DoubleLyLinnkedList;

import com.Nikunj.LinkedList.LinkedList;

import java.util.Scanner;

public class DoubleEndedLL {
    Scanner input = new Scanner(System.in);

    Node head;

    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            data = d;
            next = null;
            prev = null;
        }
    }

    public void print(){
        Node n = head;
        while (n != null){
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println();
    }

    public Node createNewNode(){
        int data = input.nextInt();
        Node p = new DoubleEndedLL.Node(data);
        return p;
//        System.out.println("Node created " + p.data);
    }

    public void addNodeAtBeginning(){
        Node p = createNewNode();
        p.next = head;
        head.prev = p;
        head = p;
    }

    public void addNodeAtEnd(){
        Node n = head;
        Node p = createNewNode();
        while (n.next != null){
            n = n.next;
        }
        n.next = p;
        p.prev = n;
    }

    public int length(){
        int count = 0;
        Node n = head;
        while (n != null){
            count++;
            n = n.next;
        }
        return count;
    }

    public boolean search(int value){
        Node n = head;
        int f = 0;
        while (n != null){
            if (n.data == value) f=1;
            n = n.next;
        }
        if (f==1) return true;
        return false;
    }

    public void deleteElement(int element){
        if (search(element)){
            Node p = head;
            if (p.data == element){
                head = head.next;
                head.prev = null;
                p.next = null;
            }
            else {
                while (p.data != element){
                    p = p.next;
                }
//               Node q = p;
                p.prev.next = p.next;
                p.next.prev = p.prev;
                p.next = null;
                p.prev = null;
            }
        }
        else {
            System.out.println("Not present");
        }
    }

    public int NthNode(int pos){
        if (pos <= length()){
            int count = 1;
           Node p = head;
            while (count != pos){
                p = p.next;
                count++;
            }
            return p.data;
        }
        else return -1;
    }

    public int occurrences(int element){
        int count = 0;
        Node p = head;
        while (p != null){
            if (p.data == element){
                count++;
            }
            p = p.next;
        }
        return count;
    }

    public int max(){
        Node p = head;
        int max = p.data;
        while (p != null){
            if (p.data > max){
                max = p.data;
            }
            p = p.next;
        }
        return max;
    }

    public int min(){
        Node p = head;
        int min = p.data;
        while (p != null){
            if (p.data < min){
                min = p.data;
            }
            p = p.next;
        }
        return min;
    }

    public void toCircular(){
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = head;
        head.prev = p;
    }

    public void reverse(){
        Node q;
        Node p = head;
        while (head!=null){
            q = head.prev;
            head.prev = head.next;
            head.next = q;
            head = head.prev;
        }
        while (p.prev!=null){
            p = p.prev;
        }
        head = p;
    }

    public void rotate(int n){
        int count = 0;
        while (count<n){
            Node p = head;
            while (p.next!=null){
                p=p.next;
            }
            p.next = head;
            head.prev = p;
            p.prev.next = null;
            p.prev = null;
            head = head.prev;
            count++;
        }
    }

    public void pair(int sum){
        Node first = head;
        Node second = head;
        while (second.next!=null){
            second = second.next;
        }
        while (second!=null && first!=null && second != first && second.next != first){
            if (first.data+second.data==sum){
                System.out.println(first.data + "," + second.data);
                first = first.next;
                second = second.prev;
            }
            if (first.data+second.data<sum) second = second.prev;
            if (first.data+second.data>sum) first = first.next;
        }
    }

    public void triplets(int sum){
        Node curr = head;
        while (curr.next.next!=null){
            Node first = curr.next;
            Node second = curr;
            while (second.next!=null){
                second = second.next;
            }
            while (first!=null && second != first && second.next != first){
                if (first.data+second.data==sum-curr.data){
                    System.out.println(curr.data + "," + first.data + "," + second.data);
                    first = first.next;
                    second = second.prev;
                }
                if (first.data+second.data<sum-curr.data) second = second.prev;
                if (first.data+second.data>sum-curr.data) first = first.next;
            }
            curr = curr.next;
        }
    }

    static Node push(Node head, Node new_node)
    {
        new_node.prev = null;

        new_node.next = head;

        if (head != null)
            head.prev = new_node;

        head = new_node;
        return head;
    }

    public Node reverseByGrp(Node h, int k){
        Node curr = h;
        Node p = null;
        Node n = null;
        int count = 0;
        while (count < k && curr!=null){
            n = curr.next;
            p = push(p, curr);
            curr = n;
            count++;
        }
        if (n != null){
            h.next = reverseByGrp(n,k);
            h.next.prev = head;
        }
        return p;
    }

    public static void main(String[] args) {
        DoubleEndedLL dl =  new DoubleEndedLL();

        dl.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        dl.head.next = second;
        second.prev = dl.head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;
        dl.print();
//        ll.createNewNode();

//        dl.addNodeAtBeginning();
//        dl.print();
//
//        dl.addNodeAtEnd();
//        dl.print();
//
//        System.out.println(dl.length());
//
//        System.out.println(dl.search(5));
//
//        dl.deleteElement(2);
//        dl.print();
//
//        System.out.println(dl.NthNode(3));
//
//        System.out.println(dl.occurrences(2));
//
//        System.out.println("max = " + dl.max());
//        System.out.println("min = " + dl.min());
//
//        dl.toCircular();
//        dl.print();
//
//        dl.reverse();
//        dl.print();
//
//        dl.rotate(7);
//        dl.print();
//
//        dl.pair(6);
//
//        dl.triplets(10);

        dl.head = dl.reverseByGrp(dl.head, 2);
        dl.print();
    }
}
