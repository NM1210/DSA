import java.util.*;
import java.lang.*;

class Main
{
		public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		while(true){
			int m = sc.nextInt();
			if(m==0) break;
			int a[] = new int[m];
			for(int i = 0; i<m; i++){
				a[i] = sc.nextInt();
			}
			int n = sc.nextInt();
			int b[] = new int[n];
			for(int i = 0; i<n; i++){
				b[i] = sc.nextInt();
			}
			int temp1 = 0;
			int temp2 = 0;
			int i = 0;
			int j = 0;
			int max = 0;
			while(i<m && j<n){
				if(a[i]<b[j]){
					temp1 += a[i++];
				}
				else if(a[i]>b[j]){
					temp2 += b[j++];
				}
				else{
					max += (int)Math.max(temp1, temp2) + a[i];
					temp1 = 0;
					temp2 = 0;
					i++;
					j++;
				}
			}
			while(i<m){
				temp1 += a[i++];
			}
			while(j<n){
				temp2 += b[j++];
			}
			max += (int)Math.max(temp1, temp2);
			System.out.println(max);
		}
	}
}
______________________________________________________________________________
package doubleHelix;

import java.util.*;

public class DoubleHelix {

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String phi = sc.nextLine();
		while(phi.compareTo("0")!=0){
			String first = phi;
			String second = sc.nextLine();
			String array1[] = first.split(" ");
			String array2[] = second.split(" ");
			int m = Integer.valueOf(array1[0]);
			int n = Integer.valueOf(array2[0]);
			int a[] = new int[m];
			int b[] = new int[n];
			// System.out.println(m+" "+n);
			for(int i = 0; i<m; i++){
				a[i] = Integer.valueOf(array1[i+1]);
				// System.out.print(a[i]+" ");
			}
			// System.out.println();
			for(int i = 0; i<n; i++){
				b[i] = Integer.valueOf(array2[i+1]);
				// System.out.print(b[i]+" ");
			}
			// System.out.println();
			int shorter[] = new int[(int)Math.min(m, n)];
			int longer[] = new int[(int)Math.max(m, n)];
			if(m<n){
				shorter = a;
				longer = b;
			}
			else{
				shorter = b;
				longer = a;
			}
			ArrayList<Integer> intersections = new ArrayList<>();
			for(int i = 0; i<shorter.length; i++){
				int low = 0;
				int high = longer.length-1;
				while(low<=high){
					int mid = (low+high)/2;
					if(shorter[i]<longer[mid]){
						high = mid-1;
					}
					else if(shorter[i]>longer[mid]){
						low = mid+1;
					}
					else{
						intersections.add(shorter[i]);
						break;
					}
				}
			}
			ArrayList<Integer> one = new ArrayList<>();
			ArrayList<Integer> two = new ArrayList<>();
			int len = intersections.size();
			if(len==0) {
				int sum1 = 0;
				int sum2 = 0;
				for(int i = 0; i<m; i++) {
					sum1+=a[i];
				}
				for(int i = 0; i<n; i++) {
					sum2+=b[i];
				}
				System.out.println(Math.max(sum1, sum2));
			}
			else {
				int k = 0;
				for(int i = 0; i<m; ){
					if(k<len) {
						int sum = 0;
						while(k<intersections.size() && i<m && a[i]<intersections.get(k)){
							sum+=a[i++];
						}
						one.add(sum);
						one.add(intersections.get(k++));
					}
					i++;
				}
				int j = a.length-1;
				int s = 0;
				while(a[j]>intersections.get(len-1)) {
					s+=a[j--];
				}
				one.add(s);
				k = 0;
				for(int i = 0; i<n; ){
					if(k<len) {
						int sum = 0;
						while(k<intersections.size() && i<n && b[i]<intersections.get(k)){
							sum+=b[i++];
						}
						two.add(sum);
						two.add(k<intersections.size()?intersections.get(k++):0);
					}
					i++;
				}
				j = b.length-1;
				s = 0;
				while(b[j]>intersections.get(len-1)) {
					s+=b[j--];
				}
				two.add(s);
				
//				for(Integer i: one){
//					System.out.print(i+" ");
//				}
//				System.out.println();
//				for(Integer i: two){
//					System.out.print(i+" ");
//				}
//				System.out.println();
				// for(Integer i: intersections){
				// 	System.out.print(i+" ");
				// }
				// System.out.println();
				
//				System.out.println(one.size()+" "+two.size());
				int size = one.size();
				int var1 = one.get(size-1);
				int var2 = two.get(size-1);
				for(int i = size-2; i>0; i-=2) {
					int temp = one.get(i)+Math.max(var1, var2);
					var1 = one.get(i-1)+temp;
					var2 = two.get(i-1)+temp;
				}
				System.out.println(Math.max(var1, var2));
			}
			phi = sc.nextLine();
		}
	}

}
