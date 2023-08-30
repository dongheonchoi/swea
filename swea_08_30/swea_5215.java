package swea_08_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class swea_5215 {
	
	public static int[][] map;
	public static boolean[] tf;
	public static int N;
	public static int L;
	public static int Max;
	public static int[] Score;
	public static int[] Kal;
	

	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			Score = new int[N];
			Kal = new int[N];
			Max = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				Score[i] = Integer.parseInt(st.nextToken());
				Kal[i] = Integer.parseInt(st.nextToken());
			}
			
			cal(0 , 0 , 0);
			
			sb.append("#"+tc+" " +Max).append("\n");
			
			
		}
		System.out.println(sb);
		
	}
	public static void cal(int idx , int kal ,int score) {
		if (kal > L) {
			return;
		}
		if (score > Max) {
			Max = score;
		}
		if (idx == N) {
			return;
		}
		cal(idx + 1 , kal + Kal[idx], score + Score[idx]);
		cal(idx + 1 , kal, score);

	}
	
}
