package com.Nikunj.Queue.Q15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AnagramLevel {

    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }

    static boolean areAnagrams(Node root1, Node root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        Queue<Node> t1 = new LinkedList<>();
        Queue<Node> t2 = new LinkedList<>();
        t1.add(root1);
        t2.add(root2);

        while (true){    //cool sh*t
            int n1 = t1.size();
            int n2 = t2.size();

            if (n1!=n2) return false;

            if (n1 == 0) break;

            ArrayList<Integer> level1 = new ArrayList<>();
            ArrayList<Integer> level2 = new ArrayList<>();

            while (n1>0){
                Node tempNode1 = t1.remove();
                if (tempNode1.left!=null) t1.add(tempNode1.left);
                if (tempNode1.right!=null) t2.add(tempNode1.right);
                n1--;

                Node tempNode2 = t2.remove();
                if (tempNode2.left!=null) t1.add(tempNode2.left);
                if (tempNode2.right!=null) t2.add(tempNode2.right);

                level1.add(tempNode1.data);
                level2.add(tempNode2.data);
            }
            Collections.sort(level1);
            Collections.sort(level2);

            if (!level1.equals(level2)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println(areAnagrams(root1, root2)? "Yes" : "No");
    }
}
