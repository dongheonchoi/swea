package swea_08_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_7102 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N+M+1];
			
			for (int i = 1; i <= N; i++) {
				for (int j = i+1; j <= i+M; j++) {
					arr[j]++;
				}
			}
			int max = 0;
			Queue<Integer> res = new LinkedList();
			for (int i = 2; i <= N+M; i++) {
				if (max < arr[i]) {
					max = arr[i];
					res.clear();
				}
				if (max == arr[i]) {
					res.add(i);
				}
			}
			
			sb.append("#"+tc);
			while (!res.isEmpty()) {
				sb.append(" " + res.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb);		
	}

}
