package swea_8_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1213 {

	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			
			String[][] map =  new String[100][100];
			
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				map[i] = str.split("");
			}
			
			
			flag:
			for (int i = 100; i >= 1; i--) {
				for (int j = 0; j < 100; j++) {
					for (int j2 = 0; j2 <= 100-i; j2++) {
						int cnt1 = 0;
						int cnt2 = 0;
						flag2:
						for (int k = 0; k < i/2; k++) {
							if (map[j2 + k][j].equals(map[i + j2 - k - 1][j]) ) {
								cnt1++;

							}else {
								break flag2;
							}
						}
						
						flag3:
						for (int l = 0; l < i/2; l++) {
							
							if (map[j][j2+ l].equals(map[j][i+j2-l-1]) ) {
								cnt2++;
							}else {
								break flag3;
							}							
						}	
						if (cnt1 == i/2 || cnt2 == i/2) {
							sb.append("#"+tc + " " + i).append("\n");
							break flag;
						}
					}
				}
			}
			
			
			
		}
		System.out.println(sb);
	}
	
	
	
	
}
