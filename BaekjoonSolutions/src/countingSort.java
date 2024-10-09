import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//sorting the input numbers using counting sort
public class countingSort{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //get the length for input array
		
		int[] inputArr = new int[n];//declare input array with size n
		
		int[] count = new int[10001];//array that will do counting of occurrence, max+1(range 10,000+1)
		
		int[] outputArr = new int[n];
		
		//get input
		for(int i=0;i<n;i++) {
			inputArr[i]=Integer.parseInt(br.readLine());
		}
		
		//in count array , to store the count of each unique element , store them in respective indices so do +1 for each index
		for(int i=0;i<n;i++) {
			count[inputArr[i]]++;
		}
		
		//cumulative sum to help place input array at the correct index in output array
		for(int i=1;i<count.length;i++) {
			count[i] +=count[i-1];
		}
		
		//sort
		for(int i=inputArr.length-1;i>=0;i--) {//iterate from the end of input array to preserves the order of equal elements making the algorithm stable
		outputArr[count[inputArr[i]]-1]=inputArr[i];
		count[inputArr[i]]--;
			
		}
		
		StringBuilder sb =new StringBuilder();
		for(int i: outputArr) {
			sb.append(i).append("\n");//output
		}
		System.out.println(sb);
	
	}
	
	

}
