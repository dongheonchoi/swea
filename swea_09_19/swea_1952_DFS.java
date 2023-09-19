package swea_09_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1952_DFS {
	static int res , day , oMon, tMon, year;
	static int[] month;

	public static void main(String[] args)throws IOException { //DFS
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			
			month = new int[12];

			
			day = Integer.parseInt(st.nextToken());
			oMon = Integer.parseInt(st.nextToken());
			tMon = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			res = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine(), " ");
		
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			DFS(0 , 0);
			
			sb.append("#" +tc +" "  + Math.min(year, res) + "\n");
		
		}
		System.out.println(sb);
		
	}
	
	static void DFS(int mon , int price) {
		if (price > res) {
			return;
		}
		if (mon >= 12) {
			res = price;
			return;
		}
		if (month[mon] == 0) {
			DFS(mon + 1 , price);
		}else {
			DFS(mon + 1 , price + month[mon]*day);
			DFS(mon + 1 , price + oMon);
			DFS(mon + 3 , price + tMon);
		}

		
	}
	
	
}
