package com.Nikunj.Queue.Q13;

import java.util.LinkedList;
import java.util.Queue;

public class NearestOne {

    static int[][] matrix = {{0,0,0,1},
                             {0,0,1,1},
                             {0,1,1,0}};
    static boolean[][] visited = new boolean[matrix.length][matrix[0].length];

    static boolean check(int i, int j){
        if (i<matrix.length && i>=0 && j<matrix[0].length && j>=0){
            if (matrix[i][j]==0 && visited[i][j]==false){
                return true;
            }
            else return false;
        }
        else return false;
    }

    public static void main(String[] args) {
        int c = 0;
        int delimiter[] = {-1,-1};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[0].length; j++){
                if (matrix[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }
        q.add(delimiter);
        while (!q.isEmpty()){
            int element[] = q.remove();
            if (element[0] != delimiter[0] && element[1] != delimiter[1]) {
                matrix[element[0]][element[1]] = c;
                visited[element[0]][element[1]] = true;
                if (check(element[0] - 1, element[1])) {
                    matrix[element[0] - 1][element[1]] = 2;
                    q.add(new int[]{element[0] - 1, element[1]});
                }
                if (check(element[0] + 1, element[1])) {
                    matrix[element[0] + 1][element[1]] = 2;
                    q.add(new int[]{element[0] + 1, element[1]});
                }
                if (check(element[0], element[1] - 1)) {
                    matrix[element[0]][element[1] - 1] = 2;
                    q.add(new int[]{element[0], element[1] - 1});
                }
                if (check(element[0], element[1] + 1)) {
                    matrix[element[0]][element[1] + 1] = 2;
                    q.add(new int[]{element[0], element[1] + 1});
                }
            }
            else {
                if (!q.isEmpty()) q.add(delimiter);
                c++;
            }
        }
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
