package swea_08_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4613 {
	
	public static int[][] cnt;
	public static int[][] sum;
	public static int N;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= test_case ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			cnt = new int[N][3];
			
			
			for (int i = 0; i < N; i++) {
				String[] wbr = br.readLine().split("");
				for (int j = 0; j < wbr.length; j++) {
					if (wbr[j].equals("W") ) {
						cnt[i][0]++;
					}else if (wbr[j].equals("B") ) {
						cnt[i][1]++;
					}else{
						cnt[i][2]++;
					}
				}
			}

			 
			sum = new int[N][3]; 
			
			
			count(0 , 0 , 0); // 첫 줄은  하양 
			
			
			sb.append("#" + tc + " " + (N*M - sum[N-1][2])).append("\n"); // 마지막줄은 빨강
			
		}
		System.out.println(sb);
		
		
	}

	public static void count(int wbr, int line , int presum) {
		presum += cnt[line][wbr];
		if (presum < sum[line][wbr] ) { // n번째 줄이 특정한 색일 때 최대값을 구한다. 아닐경우 return.
			return;
		}
		sum[line][wbr] = presum;
		
		line++;
		
		if (line == N ) { // 마지막 줄일 경우 return;
			return ;
		}

		
		if (wbr == 0) {
			count(0, line, presum);
			count(1, line, presum);
			
		}else if(wbr == 1) {
			
			count(1, line, presum);
			count(2, line, presum);
		}else if(wbr == 2) {
			
			count(2, line, presum);
		}
		

	}
	
}
