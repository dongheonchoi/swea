import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_11315 {
	
	static int[] dr = {0, 1, 1, 1};
	static int[] dc	= {1, 0, 1, -1};
	static String[][] board;
	static int N;
	
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int test_case = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= test_case; tc++) {
        	N = Integer.parseInt(br.readLine());
        	board = new String[N][N];
        	boolean five = false;
        	
        	for (int i = 0; i < N; i++) {
        		board[i] = br.readLine().split("");
			}
        	flag :
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
					if (board[i][j].equals("o") && check(i , j)) {
						five = true;
						break flag;
					}
				}
			}
			
			if (five) {
				sb.append("#"+tc+" YES\n");
			}else {
				sb.append("#"+tc+" NO\n");				
			}
        	
        	
        	
		}
        System.out.println(sb);
	}
	
	public static boolean check(int i, int j) {
		boolean five = false;

		
		flag:
		for (int j2 = 0; j2 < 4; j2++) {
			int sr = i;
			int sc = j;
			int count = 0;
			for (int k = 0; k < 4; k++) {
				if (sr+dr[j2] >= 0 && sc+dc[j2] >= 0 && sr+dr[j2] < N && sc+dc[j2] < N && board[sr+dr[j2]][sc+dc[j2]].equals("o")) {
					count++;
					sr = sr+dr[j2];
					sc = sc+dc[j2];
				}else {
					break;
				}
				
				if (count == 4) {
					five = true;
					break flag;
				}
			}
		}
		
		return five;
	}
	
}
