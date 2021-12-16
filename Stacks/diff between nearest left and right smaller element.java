package com.Nikunj.Stacks.Q16;

import java.util.Stack;

public class Q16 {
    static int[] a = {6, 2, 5, 4, 5, 1, 6};
    int diff;
    Stack<Integer> s;
    Q16(){
        diff = Integer.MIN_VALUE;
        s = new Stack<>();
    }

    public void maxDiff(int ll, int up){
        int d;
        if (ll == -1 && up != a.length){
            d = a[up];
        }
        else if (ll != -1 && up == a.length){
            d = a[ll];
        }
        else if (ll == -1 && up == a.length){
            d = 0;
        }
        else d = Math.abs(a[up]-a[ll]);
        if (d > diff){
            diff = d;
        }
    }

    public void selectBar(int index){
        if (s.isEmpty()){
            s.push(index);
        }
        else {
            if (a[index] > a[s.peek()]){
                s.push(index);
            }
            else {
                while (a[index] < a[s.peek()]){
                    int top = s.pop();
                    if (s.isEmpty()){
                        maxDiff(-1, index);
                        break;
                    }
                    else maxDiff(s.peek(), index);
                }
                s.push(index);
            }
        }
    }

    public static void main(String[] args) {
        Q16 diff = new Q16();
        for (int i = 0; i<a.length; i++){
            diff.selectBar(i);
        }
        while (!diff.s.isEmpty()){
            int top = diff.s.pop();
            if (diff.s.isEmpty()) diff.maxDiff(-1, a.length);
            else diff.maxDiff(diff.s.peek(), a.length);
        }
        System.out.println(diff.diff);
    }
}
