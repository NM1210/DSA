//MEMOIZATION:-

import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		Solution obj = new Solution();
		int t = sc.nextInt();
		for(int test = 0; test<t; test++){
			int h = sc.nextInt();
			int a = sc.nextInt();
			int curr = 0;
			if(h<=0 || a<=0) System.out.println(0);
			else System.out.println(obj.solve(curr, h+3, a+2));
		}
	}
}
class Solution{
	static int dp[][][];
	static int time(int curr, int h, int a){
		if(h<=0 || a<=0) return 0;
		if(dp[curr][h][a]!=-1) return dp[curr][h][a];
		if(curr==0){
			return dp[curr][h][a] = Math.max(time(1, h-5, a-10), time(2, h-20, a+5))+1;
		}
		else if(curr==1){
			return dp[curr][h][a] = Math.max(time(0, h+3, a+2), time(2, h-20, a+5))+1;
		}
		else{
			return dp[curr][h][a] = Math.max(time(1, h-5, a-10), time(0, h+3, a+2))+1;
		}
	}
	int solve(int curr, int h, int a){
		dp = new int[3][1500][1500];	//<-- HIGHLIGHT / HACKING
		for(int[][] grid: dp){
			for(int[] row: grid) Arrays.fill(row, -1);
		}
		return time(curr, h, a);
	}
}
//________________________________________________________________________________________________________________
//RECURRSION:-

import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		Solution obj = new Solution();
		int t = sc.nextInt();
		for(int test = 0; test<t; test++){
			int h = sc.nextInt();
			int a = sc.nextInt();
			char curr = 'A';
			System.out.println(obj.time(curr, h+3, a+2));
		}
	}
}
class Solution{
	int time(char curr, int h, int a){
		if(h<=0 || a<=0) return 0;
		if(curr=='A'){
			return Math.max(time('W', h-5, a-10), time('F', h-20, a+5))+1;
		}
		else if(curr=='W'){
			return Math.max(time('A', h+3, a+2), time('F', h-20, a+5))+1;
		}
		else{
			return Math.max(time('W', h-5, a-10), time('A', h+3, a+2))+1;
		}
	}
}