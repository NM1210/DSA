package com.Nikunj.Stacks.Q7;

import javax.swing.event.MenuKeyListener;
import java.util.Stack;

class Q7 {

    static int matrix[][] = {{0, 0, 1, 0},
                      {0, 0, 1, 0},
                      {0, 0, 0, 0},
                      {0, 0, 1, 0}};

    static boolean isKnown(int a, int b){
        boolean res = (matrix[a][b]==1)?true:false;
        return res;
    }

    static int perform(){
        Stack<Integer> s = new Stack<>();
        int c;
        for (int i = 0; i<matrix.length; i++){
            s.push(i);
        }
        while (s.size()>1){
            int a = s.pop();
            int b = s.pop();
            if (isKnown(a,b)) s.push(b);
            else s.push(a);
        }
        c = s.pop();
        for (int i = 0; i<matrix.length; i++){
            if (i!=c && (isKnown(c,i) || !isKnown(i,c))){
                return -1;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 4;
        if (perform()==-1) System.out.println("celeb not here");
        else System.out.println("celeb here at id " + perform());
    }
}
