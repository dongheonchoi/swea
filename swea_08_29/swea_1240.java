package swea_08_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1240 {
	
	static public String[] str;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			sb.append("#" + tc);

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			loof:
			for (int i = 0; i < N; i++) {
				str = br.readLine().split("");
				for (int j = 0; j < str.length; j++) {
					if (str[j].equals("1")) {
						for (int j2 = i; j2 < N-1; j2++) {
							br.readLine();
						}
						break loof;
					}
				}
			}


			int[] cnt = new int[33];
			int point = 0;
			for (int j = 1; j < str.length; j++) {
				if (str[j-1].equals(str[j])) {
					cnt[point]++;
				}else {
					point++;
					cnt[point]++;
				}
			}
			
			int[] num = new int[8];
			
			for (int i = 0, start = 1; i < 8; i++ , start+=4) {
				int fir = cnt[start];
				int sec = cnt[start+1];
				int thi = cnt[start+2];
				
				if (fir == 2 && sec == 1 && thi == 1) {
					num[i] = 0;
				}else if (fir == 2 && sec == 2 && thi == 1) {
					num[i] = 1;
				}else if (fir == 1 && sec == 2 && thi == 2) {
					num[i] = 2;
				}else if (fir == 4 && sec == 1 && thi == 1) {
					num[i] = 3;
				}else if (fir == 1 && sec == 3 && thi == 2) {
					num[i] = 4;
				}else if (fir == 2 && sec == 3 && thi == 1) {
					num[i] = 5;
				}else if (fir == 1 && sec == 1 && thi == 4) {
					num[i] = 6;
				}else if (fir == 3 && sec == 1 && thi == 2) {
					num[i] = 7;
				}else if (fir == 2 && sec == 1 && thi == 3) {
					num[i] = 8;
				}else if (fir == 1 && sec == 1 && thi == 2) {
					num[i] = 9;
				}
				
			}
			
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < 8; i++) {
				if (i%2 == 0) {
					sum1 += num[i];
				}else {
					sum2 += num[i];
				}
			}
			
			if ((sum1*3+sum2)%10 == 0) {
				sb.append(" " + (sum1+sum2)).append("\n");
			}else {
				sb.append(" " + 0).append("\n");				
			}
	
		}
		System.out.println(sb);

	}

}
