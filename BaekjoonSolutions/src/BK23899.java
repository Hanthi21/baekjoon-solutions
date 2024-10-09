import java.io.*;
import java.util.*;

public class BK23899 {
	static boolean check(int n, int[] a,int[] b) {
		for(int i=0;i<n;i++) {
			if(a[i]!=b[i]) return false;
		}
		return true;
	}
static boolean solve() throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//get input
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());//get the array size

	
	
	int[] A = new int[n]; //declare array A with size n
	int[] B = new int[n];//declare array B with size n
	
	st = new StringTokenizer(br.readLine());
	for(int i=0;i<n;i++) {
		A[i] = Integer.parseInt(st.nextToken());
	}
	st = new StringTokenizer(br.readLine());
	for(int i=0;i<n;i++) {
		B[i] = Integer.parseInt(st.nextToken());
	}
	
	if(check(n,A,B)) return true;
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
			
				}
		if(check(n,A,B)) return true;
		}
		return false;
		}

public static void main(String[] args) throws IOException {
	
	System.out.println(solve() ? 1:0);
		
	



}
			}
	

