import java.io.*;
import java.util.*;
//selection algorithm finding qth smallest element and printing the array after k swaps
public class BKJ24399 {
//counter for num of swaps
	static int swapCount =0;
	static int K;//number of swaps after which the array has to be printed
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//size of array
		int Q = Integer.parseInt(st.nextToken());//qth smallest ele to find
		K = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		
		//get input and populate them into array
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		//perform the selection fun to find the Qth smallest ele
		select(A,0,N-1,Q);
		
		//checking if swapCount<K
		if(swapCount<K) {
			System.out.println("-1");
			
		}
		else {
			//Print the array after K swaps
		StringBuilder sb = new StringBuilder();
		for(int num:A) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString().trim());
		}
	}
	static int select(int[] A,int p,int r,int q) {
		if(p==r) { //subarray has only one element
			return A[p];
		}
		
		//partition the array to get pivot element
		int t= partition(A,p,r);
		
		//k is the position of pivot element in the sorted array
		int k = t-p+1;
		
		if(q<k) {
			return select(A,p,t-1,q);
			
		}else if(q==k) {
			return A[t];
		}else {
			return select(A,t+1,r,q-k);
		}
	}
	
	
	//partition function and counting the swaps
	static int partition(int[] A,int p, int r) {
		int x = A[r];//pivot element
		int i =p-1;
		
		for(int j=p;j<=r-1;j++) {
			if(A[j]<=x) {
				i++;
				swap(A,i,j);
			}
		}
		if(i+1!=r) {
			swap(A,i+1,r);
		}
		return i+1;
	}
	
	
	//track swap and determine when to output the array
	static void swap(int[] A,int i,int j) {
		int tmp = A[i];
		A[i] =A[j];
		A[j] =tmp;
		
		swapCount++;
		
		//when the swap count reaches K , print the array and exit the loop
		if(swapCount==K) {
			StringBuilder sb = new StringBuilder();
			for(int num:A) {
				sb.append(num).append(" ");
			}
			System.out.println(sb.toString().trim());
			System.exit(0);
		}
	}
	
}

//stringbuilder is used to concatenate strings for the output , more efficient
