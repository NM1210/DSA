package com.Nikunj.Stacks.Q19;

import java.util.Scanner;
import java.util.Stack;

class StackElement{
    public int operation;
    public String value;
}

public class Q19 {
    static Stack<StackElement> opstack = new Stack<>();
    static Stack<Character> charstack = new Stack<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, op, k;
        n = input.nextInt();
        for (int i = 0; i<n; i++){
            op = input.nextInt();
            if (op == 1){
                String str = input.next();
                if (input.hasNextLine()){
                    input.nextLine();
                }
                append(str);
            }
            else {
                if (op == 2){
                    k = input.nextInt();
                    delete(k);
                }
                else if (op == 3){
                    k = input.nextInt();
                    print(k);
                }
                else {
                    undo();
                }
            }
        }
    }

    public static void append(String str){
        for (int i = 0; i<str.length(); i++){
            charstack.push(str.charAt(i));
        }
        StackElement insert = new StackElement();
        insert.operation = 1;
        insert.value = String.valueOf(str.length());
        opstack.push(insert);
    }

    public static void delete(int k){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i<k; i++){
            temp.append(charstack.pop());
        }
        StackElement insert = new StackElement();
        insert.operation = 2;
        insert.value = temp.reverse().toString();
        opstack.push(insert);
    }

    public static void print(int k){
        Stack<Character> temp = new Stack<>();
        for (int i = charstack.size(); i>k; i--){
            temp.push(charstack.pop());
        }
        System.out.print(charstack.peek());
        while (!temp.isEmpty()){
            charstack.push(temp.pop());
        }
    }

    public static void undo(){
        StackElement top = opstack.pop();
        if (top.operation == 1){
            int temp = 0;
            while (temp < Integer.valueOf(top.value)){
                charstack.pop();
                temp++;
            }
        }
        else {
            for (int i = 0; i<top.value.length(); i++){
                charstack.push(top.value.charAt(i));
            }
        }
    }
}


