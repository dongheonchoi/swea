import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1979 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine() , " ");
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = Integer.parseInt(st.nextToken());
				}
			}
			

			boolean flag = true;
			int cnt = 0;
			for (int j = 0; j < map.length; j++) {
				
				for (int j2 = 0; j2 < map.length-K+1; j2++) {
					
					for (int l = 0; l < K; l++) {
						if (map[j][j2+l] != 1) {
							flag = false;
							break;
						}
					}
					if (flag) {
						if (j2+K == N || map[j][j2+K] == 0) {
							if (j2 - 1 < 0 || map[j][j2-1] == 0) {
								flag = true;								
							}else {
								flag = false;
							}
						}else {
							flag = false;
						}
					}
					if (flag) {
						cnt++;
					}
					flag = true;

				}	
			}
			
			for (int j2 = 0; j2 < map.length; j2++) {
				
				for (int j = 0; j < map.length-K+1; j++) {
					
					for (int l = 0; l < K; l++) {
						if (map[j+l][j2] != 1) {
							flag = false;
							break;
						}
					}
					if (flag) {
						if (j+K == N || map[j+K][j2] == 0 ) {
							if (j - 1 < 0 || map[j-1][j2] == 0) {
								flag = true;								
							}else {
								flag = false;
							}
						}else {
							flag = false;
						}
					}
					if (flag) {
						cnt++;
					}
					flag = true;

				}	
			}

			sb.append("#"+(i+1)+" " + cnt ).append("\n");
		}
		
		
        System.out.println(sb);
	}
}
