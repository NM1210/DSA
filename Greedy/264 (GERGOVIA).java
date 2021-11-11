import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			int a[] = new int[n];
			for(int i = 0; i<n; i++){
				a[i] = sc.nextInt();
			}
//			 for(int i = 0; i<n; i++){
//			 	System.out.print(a[i]+" ");
//			 }
			// System.out.println();
			Stack<Integer> s = new Stack<>();
			int steps = 0;
			for(int i = 0; i<n; i++){
				if(s.isEmpty()) s.push(i);
				else{
					if((a[i]>0 && a[s.peek()]>0) || (a[i]<0 && a[s.peek()]<0)){
						s.push(i);
					}
					else {
						while((a[i]<0 && a[s.peek()]>0) || (a[i]>0 &&a[s.peek()]<0)){
							int top = s.pop();
							if(Math.abs(a[top])>=Math.abs(a[i])){
								a[top] += a[i];
								steps += ((i-top)*Math.abs(a[i]));
								a[i] = 0;
								if(a[top]!=0) s.push(top);
							}
							else{
								a[i] += a[top];
								steps += ((i-top)*a[top]);
								a[top] = 0;
							}
							// for(int j = 0; j<n; j++){
							//  	System.out.print(a[j]+" ");
							//  }
							// System.out.println();
							if(s.isEmpty()) break;
						}
						if(a[i]!=0) s.push(i);
					}
				}
			}
			System.out.println(steps);
		}
	}
}