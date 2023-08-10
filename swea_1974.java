import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1974 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[9][9]; 
		
		for (int tc = 1; tc <= n; tc++) {
			boolean tf = false;
			int[] num = new int[9]; 
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine() , " ");
				for (int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			flag:
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					num[board[i][j]-1]++;
				}
				for (int j = 0; j < 9; j++) {
					if (num[0] != num[j]) {
						tf = true;
						break flag;
					}
				}
			}
			if (tf) {
				sb.append("#"+(tc)+" " + 0).append("\n");
				continue;
			}
			
			flag:
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					num[board[j][i]-1]++;
				}
				for (int j = 0; j < 9; j++) {
					if (num[0] != num[j]) {
						tf = true;
						break flag;
					}
				}
			}
			if (tf) {
				sb.append("#"+(tc)+" " + 0).append("\n");
				continue;
			}
			
			flag:
			for (int i = 0; i < 9; i+=3) {
				for (int j = 0; j < 9; j+=3) {
					for (int j2 = 0; j2 < 3; j2++) {
						for (int k = 0; k < 3; k++) {
							num[board[i+j2][j+k]-1]++;
							
						}
					}
					for (int k2 = 0; k2 < 9; k2++) {
						if (num[0] != num[k2]) {
							tf = true;
							break flag;
						}
					}	
				}
			}
			
			if (tf) {
				sb.append("#"+(tc)+" " + 0).append("\n");
				continue;
			}
			
			
			
			
			sb.append("#"+(tc)+" " + 1).append("\n");
			
		}
		
        System.out.println(sb);
	}
}
