import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1206 {
	public static void main(String args[]) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			int a = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			int[] arr = new int[a];
			for (int j = 0; j < a; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int[] arr1 = arr.clone();
			for (int j = 0; j < a-1; j++) {
				arr1[j+1]-=arr[j];
			}
			for (int j = 0; j < a-2; j++) {
				if (arr1[j+2] > arr[j+2] - arr[j]) {
					arr1[j+2] = arr[j+2] - arr[j];
				}
			}
			for (int j = a-1; j >= 1; j--) {
				if(arr1[j-1] > arr[j-1] - arr[j] ) {
					arr1[j-1] =arr[j-1] - arr[j];
				}
			}
			for(int j = a-1; j >= 2; j--) {
				if(arr1[j-2] > arr[j-2] - arr[j] ) {
					arr1[j-2] =arr[j-2] - arr[j];
				}
			}
			
			for (int j = 0; j < arr1.length; j++) {
				if (arr1[j] > 0) {
					sum += arr1[j];					
				}
			}
			sb.append("#"+(i+1)+" "+ sum).append("\n");
		}
		
		System.out.println(sb);

        
	}
}
