//OPTIMIZED:-

import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int counter = 0; counter<t; counter++){
			int m = sc.nextInt();
			int n = sc.nextInt();
			int castles = sc.nextInt();
			int len = castles+2;
			int x[] = new int[len];
			int y[] = new int[len];
			x[len-1] = m+1;
			y[len-1] = n+1;
			for(int castle = 0; castle<castles; castle++){
				x[castle] = sc.nextInt();
				y[castle] = sc.nextInt();
			}
			Arrays.sort(x);
			Arrays.sort(y);
			// System.out.println(m+" "+n+" "+castles);
			// for(int castle = 0; castle<castles; castle++){
			// 	System.out.println(positions[castle][0]+" "+positions[castle][1]);
			// }
			// for(int i = 0; i<len; i++){
			// 	System.out.println(x[i]+" "+y[i]);
			// }
			int w = 0;
			int h = 0;
			for(int i = 1; i<len; i++){
				if(x[i]-x[i-1]-1>w) w = x[i]-x[i-1]-1;
			}
			for(int i = 1; i<len; i++){
				if(y[i]-y[i-1]-1>h) h = y[i]-y[i-1]-1;
			}
			System.out.println(w*h);
		}
	}
}
//_____________________________________________________________________________________
//BASIC:-

import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
				Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int counter = 0; counter<t; counter++){
			int m = sc.nextInt();
			int n = sc.nextInt();
			int castles = sc.nextInt();
			int positions[][] = new int[castles][2];
			for(int castle = 0; castle<castles; castle++){
				positions[castle][0] = sc.nextInt();
				positions[castle][1] = sc.nextInt();
			}
			// System.out.println(m+" "+n+" "+castles);
			// for(int castle = 0; castle<castles; castle++){
			// 	System.out.println(positions[castle][0]+" "+positions[castle][1]);
			// }
			int grid[][] = new int[m][n];
			for(int[] row: grid) Arrays.fill(row, 1);
			for(int castle = 0; castle<castles; castle++){
				for(int row = 0; row<m; row++){
					grid[row][positions[castle][1]-1] = 0;
				}
				for(int col = 0; col<n; col++){
					grid[positions[castle][0]-1][col] = 0;
				}
			}
			// for(int i = 0; i<m; i++){
			// 	for(int j = 0; j<n; j++){
			// 		System.out.print(grid[i][j]+" ");
			// 	}
			// 	System.out.println();
			// }
			int max = 0;
			for(int i = 0; i<m; i++){
				for(int j = 0; j<n; j++){
					if(grid[i][j]!=0){
						if(i-1<0 && j-1>=0){
							grid[i][j]=grid[i][j-1]+1;
						}
						if(i-1>=0 && j-1<0){
							grid[i][j]=grid[i-1][j]+1;
						}
						if(i-1>=0 && j-1>=0){
							grid[i][j]=grid[i-1][j]+grid[i][j-1]-grid[i-1][j-1]+1;
						}
						if(grid[i][j]>max) max = grid[i][j];
					}
				}
			}
			System.out.println(max);
		}
	}
}