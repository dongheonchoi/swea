package swea_08_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class swea_1248_3 {

	public static int V;
	public static int[][] map;

	public static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			sb.append("#" + tc);

			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map = new int[3][V + 1];  //Row 좌, 우 , 부모

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < E; i++) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if (map[0][r] == 0) {
					map[0][r] =c;
				}else {
					map[1][r] =c;
				}
				map[2][c] = r;
			}

			boolean[] parent = new boolean[V + 1];

			int start = a;
			
			while (true) {
				start = map[2][start];
				parent[start] = true;
				if (start == 1) {
					break;
				}
			}
			
			int len = 0;
			start = b;
			int point = 0;
			int tem = 0;

			while (true) {
				start = map[2][start];
				len++;
				if (parent[start]) {
					point = start;
					break;
				}
			}
			for (int i = point; i <= V; i++) {
				if (parent[i]) {
					tem++;
				}
			}
			if (len < tem) {
				len = tem;
			}

			cnt = 0;
			check(point, len);
			sb.append(" " + point + " " + cnt).append("\n");

		}
		System.out.println(sb);

	}

	public static void check(int point, int len) {
		len -= 1;
		cnt++;

		if (map[0][point] != 0) {
			check(map[0][point], len);
			if (map[1][point] != 0) {
				check(map[1][point], len);
			}
		}else {
			return;
		}
		if (len - 1 == -1) {
			return;
		}
	
	}

}
