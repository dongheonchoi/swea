package swea_10_03;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_2814_최장경로 {
	static int N;
	static int M;
	static List<ArrayList<Integer>> list;
	static boolean[] tf;
	static int res;
	
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<ArrayList<Integer>>();
			
			res = 0;
			
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				list.get(r).add(c);
				list.get(c).add(r);
				
			}
			
			for (int i = 1; i < list.size(); i++) {
				tf = new boolean[N+1];
				tf[i] = true;
				check(i , 1);
				tf[i] = false;
			}
			
			
			sb.append("#" + tc +" "+ res ).append("\n");
			
			
		}
		
		System.out.println(sb);
		

	}
	
	public static void check(int num, int cnt) {
		if (cnt > res) {
			res = cnt;
		}

		for (int i = 0; i < list.get(num).size(); i++) {
			int number = list.get(num).get(i);
			if (tf[number]) {
				continue;
			}
			tf[number] = true;
			check(number, cnt + 1);
			tf[number] = false;
		}

	}

}
