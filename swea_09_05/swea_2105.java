package swea_09_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2105 {
	static int[][] map;
	static int startR;
	static int startC;
	static int res;
	static int resCnt;
	static int N;
	static int[] dirR = {1, 1, -1, -1}; // 남동, 남서, 북서, 북동
	static int[] dirC = {1, -1, -1, 1};
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= test_case; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			res = 0;
			resCnt = 1;
			
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j < N-1; j++) {	
					long set1 = 0;
					long set2 = 0;
					int dir = 0;
					startR = i;
					startC = j;
					if (map[i][j] <= 64) {
						set1 = set1 | (1 << map[i][j]); 	
					}else {
						set2 = set2 | (1 << map[i][j]-64); 						
					}
					cal(i+1, j+1 , set1, set2, dir,  1 , 0 , 1);
				}
			}
			if (resCnt == 1) {
				sb.append("#"+tc+" " + -1+"\n");				
			}else {
				sb.append("#"+tc+" " + resCnt+"\n");
			}
			
		}
		System.out.println(sb);
	
	}// main
	public static void cal(int r, int c, long set1 ,long set2 ,int dir, int SE , int NW , int cnt) {
//		System.out.println(r+" "+ c);
		if (r == startR && c == startC ) { //원점으로 돌아온경우
			if (resCnt < cnt) {	
				resCnt = cnt;
			}
			return;
		}
		
		
		if (r < N && r >= 0 && c < N && c >= 0 ) {
			if ( map[r][c] <= 64 ) {
				if ((set1 & ((long)1 << map[r][c])) != 0 ) {
					return;					
				}else {
					set1 = set1 | ((long)1 << map[r][c]);					
				}
			}else if ( map[r][c] > 64 ){
				if ((set2 & ((long)1 << map[r][c])) != 0 ) {
					return;					
				}else {
					set2 = set2 | ((long)1 << map[r][c]-64);					
				}
			}
			
			
			
//			System.out.println(r+ " "+c +" "+sum);
			if (dir == 0) {
				cal(r + dirR[dir] , c + dirC[dir], set1, set2, dir, SE + 1, NW, cnt +1);
				dir += 1;
				cal(r + dirR[dir] , c + dirC[dir], set1, set2, dir, SE, NW, cnt +1);
			}else if(dir == 1) {
				cal(r + dirR[dir] , c + dirC[dir], set1, set2, dir, SE, NW, cnt +1);
				dir += 1;
				cal(r + dirR[dir] , c + dirC[dir], set1, set2, dir, SE, NW+1, cnt +1);
			}else if(dir == 2) {
				if (SE != NW) {
					cal(r + dirR[dir] , c + dirC[dir], set1, set2, dir, SE, NW+1, cnt +1);					
				}else if (SE == NW) {
					dir += 1;
					cal(r + dirR[dir] , c + dirC[dir], set1, set2, dir, SE, NW, cnt +1);										
				}
			}else if(dir == 3) {
				cal(r + dirR[dir] , c + dirC[dir], set1, set2, dir, SE, NW, cnt +1);
			}
		  
		}
	}
	

}
