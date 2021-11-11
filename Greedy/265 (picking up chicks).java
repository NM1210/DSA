import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		for(int test = 0; test<test_cases; test++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int b = sc.nextInt();
			int t = sc.nextInt();
			int x[] = new int[n];
			for(int i = 0; i<n; i++){
				x[i] = sc.nextInt();
			}
			int v[] = new int[n];
			for(int i = 0; i<n; i++){
				v[i] = sc.nextInt();
			}
			int rchd = 0;
			int cant_rch = 0;
			int swaps = 0;
			for(int i = n-1; i>=0; i--){
				int distance = b-x[i];
				int can_cover = v[i]*t;
				if(can_cover>=distance){
					rchd+=1;
					swaps+=cant_rch;
				}
				else{
					cant_rch+=1;
				}
				if(rchd>=k) break;
			}
			if(rchd>=k){
				System.out.println("Case #"+(test+1)+": "+swaps);
			}
			else{
				System.out.println("Case #"+(test+1)+": IMPOSSIBLE");
			}
		}
	}
}