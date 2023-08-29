package swea_08_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_10726 {

	public static void main(String[] args)throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		loof:
		for (int tc = 1; tc <= test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			
			for (int i = 0; i < N; i++) {
				if ((M % 2) != 1) {
					sb.append("#"+tc+" OFF\n");
					continue loof;
				}
				M /= 2;
			}
			
			sb.append("#"+tc+" ON\n");				
			
			
		}
		System.out.println(sb);

	}

}
