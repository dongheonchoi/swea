package swea_08_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1248 {
	
	public static int V;
	public static boolean[][] map;
	public static int cnt;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			sb.append("#"+tc);
			
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map = new boolean[V+1][V+1]; 
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < E; i++) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
			
			boolean[] parent = new boolean[V+1];
			boolean flag = true;
			int start = a;
			
			while (flag) {
				for (int i = start; i > 0; i--) {
					if(map[i][start]) {
						parent[i] = true;
						start = i;
						if (i == 1) {
							flag = false;
							break;
						}
						break;
					}
				}
			}
			
			int len = 0;
			start = b;
			int point = 0;
			
			while (!flag) {
				for (int i = start; i > 0; i--) {
					if(map[i][start]) {
						len++;
						if (parent[i]) {
							sb.append(" " + i);
							point = i;
							flag = true;
							break ;
						}
						start = i;
					}
				}
			}
			
			int tem = 0;
			for (int i = point; i < V+1; i++) {
				if (parent[i]) {
					tem++;
				}
			}
			if (len < tem) {
				len =tem;
			}
			cnt = 0;
			check(point, len);
			sb.append(" " + cnt).append("\n");
			
			
		}
		System.out.println(sb);
		
	}
	
	public static void check(int point, int len) {
		len-=1;
		cnt++;
		for (int i = point; i <= V; i++) {
			if (map[point][i]) {
//				System.out.println(point + " " + i + " " + len);
				check(i,len);
				if (len-1 == -1) {
					return;
				}
			}
		}
		return;
	}
	
	
}
