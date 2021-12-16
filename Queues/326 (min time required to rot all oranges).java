package com.Nikunj.Queue.Q11;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    static int oranges[][] = {{2,0,2,1},
                              {0,0,2,1},
                              {1,1,2,1},
                              {1,0,2,1}};

    static boolean check(int i, int j){
        if (i<oranges.length && i>=0 && j<oranges[0].length && j>=0){
            if (oranges[i][j]==1){
                return true;
            }
            else return false;
        }
        else return false;
    }

    public static void main(String[] args) {
        int count = -1;
        int delimiter[] = {-1,-1};
        Queue<int []> q = new LinkedList<>();
        for (int i = 0; i < oranges.length; i++){
            for (int j = 0; j<oranges[0].length; j++){
                if (oranges[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        q.add(delimiter);
//        while (!q.isEmpty()){
//            System.out.print(q.peek()[0] + "" + q.peek()[1] + " ");
//            q.remove();
//        }
        while (!q.isEmpty()){
            int element[] = q.remove();
            if (element[0] != delimiter[0] && element[1] != delimiter[1]){
                if (check(element[0] - 1,element[1])){
                    oranges[element[0] - 1][element[1]] = 2;
                    q.add(new int[]{element[0]-1, element[1]});
                }
                if (check(element[0] + 1,element[1])){
                    oranges[element[0] + 1][element[1]] = 2;
                    q.add(new int[]{element[0]+1, element[1]});
                }
                if (check(element[0],element[1] - 1)){
                    oranges[element[0]][element[1] - 1] = 2;
                    q.add(new int[]{element[0], element[1]-1});
                }
                if (check(element[0],element[1] + 1)){
                    oranges[element[0]][element[1] + 1] = 2;
                    q.add(new int[]{element[0], element[1]+1});
                }
            }
            else {
                count++;
                if (!q.isEmpty()) q.add(delimiter);
            }
        }
        System.out.print(count);
    }
}
