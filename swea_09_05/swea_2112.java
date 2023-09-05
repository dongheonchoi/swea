package swea_09_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2112 {
	
	static int[][] map;
	
	static int D;
	static int W;
	static int K;
	static int min;
	static boolean flag;
	

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			flag = false;
			min = K;

			
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			inject(0, 0);
			
			sb.append("#"+tc+" "+min+"\n");
			
		}
		System.out.println(sb);
		
		
	}//Main
	
	public static void inject(int r, int cnt) { //BFS를 사용하면 더 빠를 것 같은데
		if (check(cnt)) {
			return;
		}
		if (cnt >= min) {
			return;
		}
		if (r == D) {
			return;
		}
		
		check(cnt);
		
		int[] temp = map[r].clone();
		
		inject(r+1, cnt);
		
		Arrays.fill(map[r], 0);
		inject(r+1, cnt+1);

		Arrays.fill(map[r], 1);
		inject(r+1, cnt+1);
		
		map[r] = temp.clone();
		
		
	}
	
	public static boolean check(int cnt) {
		
		loof:
		for (int i = 0; i < W; i++) {
			int preN = map[0][i]; 
			int num = 1;
			for (int j = 1; j < D; j++) {
				if (map[j][i] == preN) {
					num++;
				}else {
					if (D-j < K) {
						return false;
					}
					num = 1;
					preN = map[j][i];
				}
				if (num == K) {
					continue loof;
				}
			}
		}
		if (cnt < min) {
			min = cnt;
		}
		return true;
	}
	
	
	
	
	

}
