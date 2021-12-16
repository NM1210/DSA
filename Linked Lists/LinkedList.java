package com.Nikunj.LinkedList;

import javax.print.attribute.standard.NumberOfDocuments;
import java.util.Scanner;

public class LinkedList {

    Scanner input = new Scanner(System.in);

    Node head;

    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public void print(){
        Node n = head;
        if (n == null) System.out.print("null");
        else{
            while (n != null){
                System.out.print(n.data + "->");
                n = n.next;
            }
            System.out.println();
        }
    }

    public Node createNewNode(){
        int data = input.nextInt();
        Node p = new Node(data);
        return p;
//        System.out.println("Node created " + p.data);
    }

    public void addNodeAtBeginning(){
        Node p = createNewNode();
        p.next = head;
        head = p;
    }

    public void addNodeAtEnd(){
        Node n = head;
        Node p = createNewNode();
        while (n.next != null){
            n = n.next;
        }
        n.next = p;
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
                p.next = null;
            }
            else {
                while (p.next.data != element){
                    p = p.next;
                }
                Node q = p.next;
                p.next = p.next.next;
                q.next = null;
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
    }

    public int NthNodeFromEnd(int pos){
        return NthNode(length()-pos+1);
    }

    public boolean isPalindrome(){
        int f = 0;
        for (int i = 1; i<=length(); i++){
            if (NthNode(i) != NthNodeFromEnd(i)){
                f = 1;
            }
        }
        if (f == 1) return false;
        else return true;
    }

    public void reverse(){
        Node last = head;
        int l = length();
        while (last.next != null){
            last = last.next;
        }
        Node head2 = last;
        for (int i = 1; i<l; i++){
            Node p = head;
            while (p.next != last){
                p = p.next;
            }
            last.next = p;
            last = last.next;
        }
        last.next = null;
        head = head2;
    }

    public Node reverseRecursively(Node h){
        if (h==null||h.next==null){
            return h;
        }
        Node rest = reverseRecursively(h.next);
        h.next.next = h;
        h.next = null;
        return rest;
    }

    public boolean isLoop(){
        Node p = head;
        Node q;
        int f = 0;
        while (f == 0){
            q = head;
            if (p == null) break;
            else {
                while (q != p){
                    if (p.next == null) f = 0;
                    else if (q == p.next) f = 1;
                    q = q.next;
                }
            }
            p = p.next;
        }
        q = p.next;
        if (f == 1){
            int l = 1;
            while (q!=p){
                l++;
                q = q.next;
            }
            System.out.println(l);
            return true;
        }
        else return false;
    }

    public void delete(){
        head = null;
    }

    public void removeFromSorted(){
        Node p = head;
        while (p.next != null){
            while (p.data == p.next.data){
                Node q = p.next;
                p.next = p.next.next;
                q.next = null;
            }
            p = p.next;
        }
    }

    public void removeFromUnsorted(){
        Node p = head;
        while (p.next != null){
            Node q = p;
            while (q.next != null){
                if (q.next.data == p.data){
                    Node r = q.next;
                    q.next = q.next.next;
                    r.next = null;
                }
                q = q.next;
                if (q == null) break;
            }
            p = p.next;
        }
    }

    public void lastToFirst(){
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = head;
        Node q = head;
        while (q.next != p){
            q = q.next;
        }
        head = q.next;
        q.next = null;
    }

    public void add1(int lim){
        if (lim==0){
            Node p = new Node(1);
            p.next = head;
            head = p;
        }
        else {
            int count = 1;
            Node p = head;
            while (count<lim){
                count++;
                p=p.next;
            }
            if (p.data + 1 > 9){
                p.data = 0;
                add1(lim-1);
            }
            else p.data = p.data + 1;
        }
    }

    public void addLists(int lim, LinkedList ll2, int pos, int carry){
//        if (length() == ll2.length()){
            if (lim == 0){
                if (pos <= ll2.length()){
                    if (ll2.NthNodeFromEnd(pos)+carry > 9){
                        int exp = ll2.NthNodeFromEnd(pos) + carry;
                        Node p = new Node(exp%10);
                        p.next = head;
                        head = p;
                        addLists(lim, ll2, pos+1,exp/10);
                    }
                    else {
                        int exp = ll2.NthNodeFromEnd(pos) + carry;
                        Node p = new Node(exp);
                        p.next = head;
                        head = p;
                    }
                }
                else if (carry!=0){
                    Node p = new Node(carry);
                    p.next = head;
                    head = p;
                }
            }
            else {
                int count = 1;
                Node p = head;
                while (count<lim) {
                    count++;
                    p = p.next;
                }
                if (pos > ll2.length()){
                    if (p.data + carry > 9){
                        int exp = p.data + carry;
                        p.data = exp%10;
                        addLists(lim-1, ll2, pos, exp/10);
                    }
                    else {
                        int exp = p.data + carry;
                        p.data = exp;
                    }
                }
                else if (p.data + ll2.NthNodeFromEnd(pos) + carry > 9){
                    int exp = p.data + ll2.NthNodeFromEnd(pos) + carry;
                    p.data = exp % 10;
                    addLists(lim-1, ll2,pos+1, exp/10);
                }
                else {
                    int exp = p.data + ll2.NthNodeFromEnd(pos) + carry;
                    p.data = exp;
                    addLists(lim-1, ll2,pos+1, 0);
                }
            }
//        }
    }

    public void intersection(LinkedList l1, LinkedList l2){
        Node p = l1.head;
        while (p != null){
            Node q = l2.head;
            while (q != null){
                if (p.data == q.data){
                    Node i = new Node(p.data);
                    if (head==null){
                        head = i;
                    }
                    else {
                        Node t = head;
                        while (t.next != null){
                            t = t.next;
                        }
                        t.next = i;
                    }
                }
                q = q.next;
            }
            p = p.next;
        }
    }

    public int poi(LinkedList l1, LinkedList l2){
        Node p = l1.head;
        int poi = -1;
        while (p != null){
            Node q = l2.head;
            while (q != null){
                if (p == q){
                    poi = p.data;
                }
                if (poi != -1) break;
                q = q.next;
            }
            if (poi != -1) break;
            p = p.next;
        }
        return poi;
    }

    public int middle(){
        int mid;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (length() % 2 == 0) mid = slow.next.data;
        else mid = slow.data;
        return mid;
    }

    public boolean isCircular(){
        Node p = head;
        int f = 0;
        while (p != null){
            if (p.next == head){
                f = 1;
                break;
            }
            p = p.next;
        }
        if (f == 1) return true;
        else return false;
    }

    public void printCircular(){
        Node p =head;
        while (p.next != head){
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.print(p.data + "->");
        System.out.println();
    }

    public void twoHalves(){
        Node slow = head, fast = head, p = head;
        while (fast.next!=head&&fast.next.next!=head){
            slow = slow.next;
            fast = fast.next.next;
        }
        while (p.next!=head){
            p=p.next;
        }
        p.next = slow.next;
        slow.next = head;
        LinkedList secondHalf = new LinkedList();
        secondHalf.head = p.next;
        printCircular();
        secondHalf.printCircular();
    }

    public void deleteFromCL(int element){
        Node p = head;
        int f = 0;
        while (p.next!=head){
            if (p.next.data == element){
                f = 1;
                break;
            }
            p = p.next;
        }
        if (f == 0){
            if (p.next.data==element) f = 1;
        }
        if (f == 1){
            p = head;
            while (p.next!=head){
                if (p.next.data == element){
                    Node q = p.next;
                    p.next = p.next.next;
                    q.next = null;
                }
                p=p.next;
            }
            if (p.next.data==element){
                Node q = p.next;
                p.next = p.next.next;
                head = head.next;
                q.next = null;
            }
        }
        else System.out.println("Non such element");
    }

    public int lengthOfCL(){
        Node p = head;
        int count = 1;
        while (p.next!=head){
            count++;
            p=p.next;
        }
        return count;
    }

    public void exchange(){
        Node p = head;
        while (p.next.next!=null){
            p=p.next;
        }
        Node q = p.next;
        p.next = head;
        q.next = head.next;
        head.next = null;
        head = q;
    }

    public Node reverseByGrp(Node h, int k){
        Node curr = h;
        Node p = null;
        Node n = null;
        int count = 0;
        while (count < k && curr != null){
            n = curr.next;
            curr.next = p;
            p = curr;
            curr = n;
            count++;
        }
        if (n!=null){
            h.next = reverseByGrp(n,k);
        }
        return p;
    }

    public void sort(Node start, Node end){
        if (start == end) return;

        Node pivot_prev = partitionLast(start, end);

        sort(start, pivot_prev);

        if (pivot_prev!=null && pivot_prev==start){
            sort(pivot_prev.next, end);
        }

        else if (pivot_prev!=null && pivot_prev.next!=null){
            sort(pivot_prev.next.next,end);
        }
    }

    public Node partitionLast(Node start, Node end){
        if (start == end || start == null || end == null) return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;

        while (start!=end){
            if (start.data<pivot){
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;

        return pivot_prev;
    }

    public Node mergesort(Node h){
        if (h == null || h.next==null) return h;

        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergesort(h);
        Node right  = mergesort(nextOfMiddle);

        Node sortedList = sortedMerge(left,right);

        return sortedList;
    }

    public Node sortedMerge(Node a, Node b){
        Node result = null;
        if (a == null) return b;
        if (b == null) return a;
        if (a.data<=b.data){
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public static Node getMiddle(Node head){
        if (head == null) return head;
        Node slow = head, fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
//        LinkedList l2 = new LinkedList();
//        LinkedList intersection = new LinkedList();

        ll.head = new Node(30);
        Node second = new Node(3);
        Node third = new Node(4);
        Node fourth = new Node(20);
        Node fifth = new Node(5);
//        Node sixth = new Node(1);

        ll.head.next = second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
//        fifth.next = ll.head;
//        fifth.next = sixth;
//        fifth.next=second;

//        l2.head = new Node(10);
//        Node two = new Node(6);
//        Node three = new Node(5);
//        Node four = new Node(6);

//        l2.head.next = fourth;
//        two.next = third;
//        l2.head.next = two;
//        two.next = three;
//        three.next = four;

        ll.print();
//        l2.print();

//        ll.createNewNode();
//
//        ll.addNodeAtBeginning();
//        ll.print();
//
//        ll.addNodeAtEnd();
//        ll.print();
//
//        System.out.println(ll.length());
//
//        System.out.println(ll.search(5));
//
//        ll.deleteElement(2);
//        ll.print();
//
//        System.out.println(ll.NthNode(3));
//
//        System.out.println(ll.occurrences(2));
//
//        System.out.println("max = " + ll.max());
//        System.out.println("min = " + ll.min());
//
//        ll.toCircular();
//        ll.print();
//
//        ll.print();
//        System.out.println(ll.NthNodeFromEnd(2));
//
//        System.out.println(ll.isPalindrome());
//
//        ll.reverse();
//        ll.print();
//
//        System.out.println(ll.isLoop());
//
//        ll.delete();
//        ll.print();
//
//        ll.removeFromSorted();
//        ll.print();
//
//        ll.removeFromUnsorted();
//        ll.print();
//
//        ll.print();
//        ll.lastToFirst();
//        ll.print();
//        ll.add1(ll.length());
//        ll.print();
//
//        ll.addLists(ll.length(), l2, 1, 0);
//        ll.print();
//
//        intersection.intersection(ll,l2);
//        intersection.print();
//
//        System.out.println(ll.poi(ll,l2));
//
//        System.out.println(ll.middle());
//
//        System.out.println(ll.isCircular());
//
//        ll.printCircular();
//        ll.twoHalves();
//
//        ll.deleteFromCL(15);
//        ll.printCircular();
//
//        System.out.println(ll.lengthOfCL());

//        ll.exchange();
//        ll.print();
//
//        ll.head=ll.reverseRecursively(ll.head);
//        ll.print();

//        Node n = ll.head;
//        while (n.next!= null){
//            n=n.next;
//        }
//        ll.sort(ll.head,n);
//        ll.print();

//        ll.head = ll.mergesort(ll.head);
//        ll.print();

    }
}
