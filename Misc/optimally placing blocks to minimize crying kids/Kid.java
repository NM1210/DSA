package minimum_cries;

import java.util.*;

public class Kid {

	public static int calculate_cries(int a[], boolean fixed[], int T) {
		int n = a.length;
		int kids_crying = 0;
		boolean crying[] = new boolean[n];
		for(int t = 1; t<=T; t++) {
			for(int i = 0; i<n; i++) {
				if(crying[i]!=true && a[i]<=t) {
					kids_crying++;
					crying[i] = true;
					if(i!=n-1 && fixed[i]!=true && crying[i+1]!=true) {
						a[i+1] = a[i]+1;
					}
				}
			}
		}
		return kids_crying;
	}
	public static int place_blocks(int a[], boolean fixed[], int k, int pos, int T) {
		if(pos<0) return Integer.MAX_VALUE;
		if(k==0) return calculate_cries(a, fixed, T);
		int val1 = place_blocks(a, fixed, k, pos-1, T);
		fixed[pos] = true;
		int val2 = place_blocks(a, fixed, k-1, pos-1, T);
		return Math.min(val1, val2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int T = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		boolean fixed[] = new boolean[n];
		System.out.println(place_blocks(a, fixed, k, n-1, T));
	}

}
