package swea_09_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1952_DP {

	public static void main(String[] args)throws IOException { //DP
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine() , " ");
			
			int[] month = new int[12];
			int[] price = new int[12];
			
			int day = Integer.parseInt(st.nextToken());
			int oMon = Integer.parseInt(st.nextToken());
			int tMon = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
		
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < 12; i++) {
				int d = month[i];
				if (d == 0) {
					if (i != 0) {
						price[i] = price[i-1];
					}
					continue;
				}else {
					if ( i == 0 ) {
						price[i] =  Math.min(d*day , oMon);						
					}else if ( i == 1 ) {
						price[i] = price[i-1] + Math.min(d*day , oMon);						
					}else {
						if ( i == 2) {
							price[i] = Math.min(price[i-1] + Math.min(d*day , oMon), tMon);												
						}else {
							price[i] = Math.min(price[i-1] + Math.min(d*day , oMon), price[i-3] + tMon);												
						}
					}
				}
			}
			
			sb.append("#" +tc +" " + Math.min(price[11], year) + "\n");
		
		}
		System.out.println(sb);
		
	}

}
