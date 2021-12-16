package com.Nikunj.Queue.Q10;

public class Tour {
    public static void main(String[] args) {
        int a[][] = {{4,5}, {6,5}, {7,3}, {4,6}};
        int capacity, distance;
        int start , end;
        for (int i = 0; i < a.length; i++){
            start = i;
            end = start + 1;
            capacity = a[start][0];
            distance = capacity - a[start][1];
            while (start != end){
                if (distance < 0) break;
                else {
                    capacity = distance + a[end][0];
                    distance = capacity - a[end][i];
                    end = (end+1)%a.length;
                }
            }
            if (start == end){
                System.out.print(start);
                break;
            }
        }
    }
}
