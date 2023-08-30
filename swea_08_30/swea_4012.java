package swea_08_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class swea_4012 {
	
	public static int[][] map;
	public static boolean[] tf;
	public static int N;
	public static int min;
	public static int sum;
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			min = Integer.MAX_VALUE;
			
			map = new int[N][N];
			tf = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] =Integer.parseInt(st.nextToken());
				}
			}
			
			cal(0,0);
			
			
			sb.append("#"+tc+" "+min).append("\n");
			
			
		}
		System.out.println(sb);
		
	}
	public static void cal(int cnt, int idx) {
		if (cnt == N/2) {
			cal2(0 , 0);
			return;
		}
		if (idx == N) {
			return;
		}
		
		tf[idx] = true;
		cal(cnt+1, idx+1);
		tf[idx] = false;
		cal(cnt, idx+1);
		
	}
	public static void cal2(int cnt, int idx) {
		for (int i = 0; i < N; i++) {
			if (tf[i]) {
				for (int j = i; j < N; j++) {
					if (tf[j]) {
						sum += map[i][j];
						sum += map[j][i];
					}
				}				
			}
		}
		for (int i = 0; i < N; i++) {
			if (!tf[i]) {
				for (int j = i; j < N; j++) {
					if (!tf[j]) {
						sum -= map[j][i];
						sum -= map[i][j];
					}
				}				
			}
		}
		sum = Math.abs(sum);
		if (min > sum) {
			min = sum;
		}
		sum = 0;
	}
	
}
