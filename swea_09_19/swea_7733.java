package swea_09_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_7733 {
	
	static int[][] map;
	static boolean[][] tfMap;
	static int N;
	static int cnt;
	static int res;
	static int[] dirR = {1, 0, -1, 0};
	static int[] dirC = {0, 1, 0, -1};
	

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			res = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine() , " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i < 100; i++) {
				cnt = 0;
				tfMap = new boolean[N][N];
				for (int j = 0; j < N; j++) {
					for (int j2 = 0; j2 < N; j2++) {
						if (!tfMap[j][j2] && map[j][j2] > i) {
							cnt++;
							check(j , j2 , i);							
						}
					}
				}
				if (cnt == 0) {
					break;
				}
				if(res < cnt) {
					res = cnt;
				}
				
			}
			sb.append("#"+ tc +" " + res +"\n");
		} 
		System.out.println(sb);
		
	}
	
	static void check(int r, int c , int day) {
		if (!tfMap[r][c] && map[r][c] > day) {
			tfMap[r][c] = true;
			for (int i = 0; i < 4; i++) {
				int nR = r+dirR[i];
				int nC = c+dirC[i];
				if (nR >=0 && nR < N && nC >=0 && nC < N && !tfMap[nR][nC]) {
					check(nR , nC , day);					
				}
			}
		}		
	}

}
