import java.io.*;
import java.util.*;

public class BK23881 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//get input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//get the array size
		int k = Integer.parseInt(st.nextToken());//get k-th swap
		
		
		int[] A = new int[n]; //declare array A with size n
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//for counting num of swaps made
		int swap = 0;
		
		//selection sort
		for(int last=n-1;last>0;last--) {
			int maxIndex = 0;
			
			//find index of largest ele in unsorted part
			for(int i=1;i<=last;i++) {
				if(A[i]>A[maxIndex]) {
					maxIndex = i;
				}
			}
			
			//swap to put the largest ele at current last position
			if(maxIndex != last) {
				swap++;
				int tmp = A[maxIndex];
				A[maxIndex] = A[last];
				A[last] =tmp;
				
				
				//print the result at kth swap
				if(swap == k) {
					int[] result = new int[] {A[maxIndex],A[last]};
					
					System.out.println(result[0]+" "+result[1]);
					return;
				}
			}
			
			
		}
		System.out.println(-1);
				

	}
	

}
