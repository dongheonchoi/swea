package swea_09_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class swea_3289 {
	static int[] arr;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];

			sb.append("#"+tc+" ");
			
			for (int i = 1; i <= N; i++) {
				arr[i] = i;
			}
			
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine() , " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if (a == 0) {
					union(b , c);
				}else {
					if (find(b) == find(c)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}
				
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
	
	static int find(int num) {
		if (arr[num] == num) {
			return num; 
		}else {
			return find(arr[num]);
		}
	}
	
	static void union(int a, int b) {
		int n1 = find(a);
		int n2 = find(b);
		
		if (n1 > n2) {
			arr[n1] = n2;
		}else {
			arr[n2] = n1;
		}
		
		
	}

}
