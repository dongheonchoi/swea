package swea_08_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2817 {
	
	public static int cnt; 
	public static int N; 
	public static int M; 
	public static int[] arr; 
	
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int sum = 0;
			cnt = 0;
			
			powerset(0, 0);
			
			sb.append("#"+tc+" "+cnt).append("\n");
			
			
		}
		System.out.println(sb);
		
	}
	
	public static void powerset(int sum, int idx) {
		if (sum == M) {
			cnt++;
			return;
		}
		if (sum > M || idx == N) {
			return;
		}
		
		powerset(sum + arr[idx], idx+1);
		powerset(sum, idx+1);

	}
	
	
	
	
}
