package com.Nikunj.Queue.Q18;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatedLetter {
    public static void main(String[] args) {
        String input = "aaabccbd";
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i<input.length(); i++){
            if (!input.substring(0,i).contains(String.valueOf(input.charAt(i)))){
                q.add(input.charAt(i));
                System.out.print(q.peek()+" ");
            }
            else {
                if (!q.isEmpty()){
                    if (input.charAt(i) == q.peek()){
                        q.remove();
                        if (q.isEmpty()){
                            System.out.print("-1 ");
                        }
                        else {
                            System.out.print(q.peek()+" ");
                        }
                    }
                    else {
                        while (input.charAt(i) != q.peek()){
                            q.add(q.remove());
                        }
                        q.remove();
                        System.out.print(q.peek()+" ");
                    }
                }
                else {
                    System.out.print("-1 ");
                }
            }
        }
    }
}
