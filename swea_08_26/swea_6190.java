package swea_08_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_6190 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());	
		
		
		for (int tc = 1; tc <= test_case; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			int max = 0;
			
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					if(cal(arr[i]*arr[j])) {
						if (max < arr[i]*arr[j]) {
							max = arr[i]*arr[j];						
						}
					}					
				}
			}
			
			if (max != 0) {
				sb.append("#"+tc + " " + max).append("\n");				
			}else {
				sb.append("#"+tc + " " + -1).append("\n");								
			}
		}
		
		System.out.println(sb);
	}
	
	public static boolean cal(int num) {
		int n = num;
		int remain = n % 10;
		while(n > 1) {
//			System.out.println(n);
			n /= 10; 
			int temp = n%10;
			
			if (remain >= temp) {
				remain = temp;
			}else {
				return false;
			}
		}
		return true;		
	}
	

}
