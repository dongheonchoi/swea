package swea_08_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class swea_1248_2 {

	public static int V;
	public static boolean[][] map;
	public static Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
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

			map = new boolean[V + 1][V + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < E; i++) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map2.put(c, r);
				map[r][c] = true;
			}

			boolean[] parent = new boolean[V + 1];
			boolean flag = true;
			int start = a;

			while (flag) {
				start = map2.get(start);
				parent[start] = true;
				if (start == 1) {
					break;
				}
			}

			int len = 0;
			start = b;
			int point = 0;

			while (flag) {
				start = map2.get(start);
				len++;
				if (parent[start]) {
					point = start;
					break;
				}
			}

			int tem = 0;
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

//	public static void check(int point, int len) {
//		len-=1;
//		cnt++;
//		int num = 0;
//		System.out.println(point + " " + len);
//		for (int i = point; i <= V; i++) {
//			if (map[point][i]) {
//				System.out.println(point + " " + i + " " + len);
//				check(i,len);
//				if (len-1 == -1) {
//					return;
//				}
//			}
//		}
//		return;
//	}
	public static void check(int point, int len) {
		len -= 1;
		cnt++;
		int num = 0;
		for (int i = 1; i <= V; i++) {
			if (map[point][i]) {
//			System.out.println(point + " " + i + " " + len);
				check(i, len);
				num++;
			}
			if (num == 2) {
				return;
			}
		}
		if (len - 1 == -1) {
			return;
		}
	}

}
