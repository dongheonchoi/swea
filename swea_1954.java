import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1954 {
	static int[] dr = {0,1,0,-1}; 
	static int[] dc = {1,0,-1,0};
	
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= test_case; tc++){
        	sb.append("#"+tc +"\n");
        	int N = Integer.parseInt(br.readLine());
        	int[][] snail =new int[N][N];
        	
        	int cnt = 1;
        	int r = 0;
        	int c = 0;
        	int dir = 0;
        	
        	while (cnt <= N*N) {
        		snail[r][c] = cnt;
        		if (r+dr[dir] >= N || c+dc[dir] >= N|| r+dr[dir] < 0 || c+dc[dir] < 0 || snail[r+dr[dir]][c+dc[dir]] != 0) {
					dir++;
					dir%=4;
				}
        		r = r+dr[dir];
        		c = c+dc[dir];	
        		cnt++;
			}
        	
        	for (int i = 0; i < snail.length; i++) {
				for (int j = 0; j < snail.length; j++) {
					sb.append(snail[i][j] + " ");
				}
				sb.append("\n");
			}
	
        }
        System.out.println(sb.toString());

        
	}
}
