package min_halts;
import java.util.*;

public class MinHalts {
	static int halt(int[] a, int y, int i, int skip) {
		if(i==a.length-1) return a[a.length-1];
		if(skip==2) {
			return a[i]+halt(a, y, i+1, skip);
		}
		if(skip==1) {
			return Math.min(a[i]+halt(a, y, i+1, skip+1), Math.min(a[i], y)+halt(a, y, i+1, skip+1));
		}	
		return Math.min(a[i]+halt(a, y, i+1, skip), Math.min(a[i], y)+halt(a, y, i+1, skip+1));
	}
	public static void main(String[] args) {
		int a[] = {1, 2, 4, 6, 5, 3};
		int y = 4;
		System.out.println(a[0]+halt(a, y, 1, 0));
	}

}
