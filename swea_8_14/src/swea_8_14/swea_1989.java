package swea_8_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1989 {

	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			String str = br.readLine();
			int cnt = 0;
			flag:
			for (int i = 0; i < str.length()/2; i++) {
				if (str.charAt(i) == str.charAt(str.length()-i-1)) {
					cnt ++;
				}else {
					break flag;
				}
			}

			if (cnt == str.length()/2) {
				sb.append("#" + tc + " " + 1).append("\n");
			}else {
				sb.append("#" + tc + " " + 0).append("\n");				
			}

			
		}
		System.out.println(sb);
	}
	
	
	
	
}
