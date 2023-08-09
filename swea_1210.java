import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1210 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for (int tc = 0; tc < 10; tc++) {
			
			boolean[][] check = new boolean[100][100];
			int[][] map = new int[100][100];		
			
			int a = Integer.parseInt(br.readLine());
			int start = 0;
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						start = j;
					}
				}
			}
			
			int c = 99;
			
			while (c > 0) {
				check[c][start] = true;
				
				if (start + 1 < 100 && map[c][start + 1] == 1 && !check[c][start + 1]) {
					start++;
				}else if (start - 1 >= 0 && map[c][start - 1] == 1 && !check[c][start - 1]) {
					start--;
				}else {
					c--;
				}
			}
			
			
			
			
			
            sb.append("#"+(tc+1)+" "+start ).append("\n");
		}
		
        System.out.println(sb);
	}
}
