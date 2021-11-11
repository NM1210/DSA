import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test = 0; test<t; test++){
			int n = sc.nextInt();
			Integer a[] = new Integer[n];
			for(int i = 0; i<n; i++){
				a[i] = sc.nextInt();
			}
			Arrays.sort(a, Collections.reverseOrder());
			if(a[n-1]==1){
				System.out.print(1+" ");
				n -= 1;
			}
			// long x = 1;
			// for(int i = 0; i<n; i++){
			// 	x = (long)Math.pow(a[i], x);
			// }
			if(n==2 && a[0]==3 && a[1]==2){
				System.out.print(2+" "+3+" ");
			}
			else{
				for(int i = 0; i<n; i++){
					System.out.print(a[i]+" ");
				}
			}
			System.out.println();
		}
	}
}