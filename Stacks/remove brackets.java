package com.Nikunj.Stacks.Q17;

import java.util.Stack;

public class Q17 {
    String string;
    Stack<Character> s;
    Stack<Character> temp;

    Q17(){
        string = "";
        s = new Stack<>();
        temp = new Stack<>();
    }

    public void removeBrackets(Character ch){
        if (ch == '('){
            while (s.peek()!=')'){
                temp.push(s.pop());
            }
            s.pop();
        }
        else if (ch == '-' || ch == '+' || ch == ')'){
            while (!temp.isEmpty()){
                int top = temp.pop();
                if (ch == '+' && top == '+'){
                    s.push('+');
                }
                else if (ch == '+' && top == '-'){
                    s.push('-');
                }
                else if (ch == '-' && top == '+'){
                    s.push('-');
                }
                else if (ch == '-' && top == '-'){
                    s.push('+');
                }
            }
            s.push(ch);
        }
        else {
            string = string + ch;
        }
    }

    public static void main(String[] args) {
        Q17 object = new Q17();
        String inputString = "a+b-(c-(d+e+f))";
        for (int i = inputString.length()-1; i>=0 ; i--){
            object.removeBrackets(inputString.charAt(i));
        }
        while (!object.s.isEmpty()){
            object.string = object.string + object.s.pop();
        }
        for (int i = 0; i<object.string.length(); i++){
            System.out.print(object.string.charAt(i));
        }
    }
}
