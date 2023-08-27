package swea_08_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1289 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str , "0");
			
			int res = 0;
			
			while (st.hasMoreElements()) {
				st.nextToken();
				res+=2;
			}
			
			if (str.charAt(str.length()-1) == '1') {
				res--;
			}
			
			sb.append("#"+tc+" " + res).append("\n");
			
			
		}
		System.out.println(sb);
		
	}

}
