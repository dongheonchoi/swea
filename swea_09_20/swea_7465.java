package swea_09_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_7465 {
	static ArrayList<ArrayList<Integer>> list;
	static int cnt;
	static boolean[] tf;
	

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			tf = new boolean[N+1];
			list = new ArrayList<ArrayList<Integer>>();
			cnt = 0;
			
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine() , " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				System.out.println(a + " "+ b);
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			for (int i = 1; i <= N; i++) {
				if (!tf[i]) {	
					cnt++;
					check(i);
				}
			}
			
			sb.append("#"+tc+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
	
	static void check(int idx) {
		tf[idx] = true;
		ArrayList<Integer> tem = list.get(idx);
		System.out.println(tem.toString());
		for (int i = 0; i < tem.size(); i++) {
			if (!tf[tem.get(i)]) {
				check(tem.get(i));
			}
		}
	}

}
