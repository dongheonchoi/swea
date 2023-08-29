package swea_08_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1873 {
	static public boolean tf [][];
	static public char map [][];
	static public int dir;
	static public int H;
	static public int W;
	static public int pointR;	
	static public int pointC;	
	static public String[] order;
	static public int[]  dirR = {-1, 1, 0, 0}; //위 아 왼 오
	static public int[]  dirC = {0, 0, -1, 1};
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			tf = new boolean[H][W];
			map = new char [H][W];
			
			for (int i = 0; i < H; i++) {
				String str = br.readLine();	
				for (int j = 0; j < W; j++) {
					char cha = str.charAt(j);
					map[i][j] = cha;
					if (cha == '*' || cha == '#' ||cha =='-') {
						tf[i][j] = true;
					}else if (cha == '^') {
						pointR = i;
						pointC = j;
						dir = 0;
					}else if (cha == 'v') {
						pointR = i;
						pointC = j;
						dir = 1;
					}else if (cha == '<') {
						pointR = i;
						pointC = j;
						dir = 2;
					}else if (cha == '>') {
						pointR = i;
						pointC = j;
						dir = 3;
					}
				}
			}
			
			int len = Integer.parseInt(br.readLine());
			
			order = br.readLine().split("");
			
			for (int i = 0; i < len; i++) {
				game(order[i]);
			}
			sb.append("#"+tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
			
	}
	public static void game(String order) {
		if (order.equals("S")) {
			int bulletR = pointR;
			int bulletC = pointC;
			
			while(true) {
				bulletR += dirR[dir];
				bulletC += dirC[dir];
				if (bulletR >= 0 && bulletR < H && bulletC >= 0 && bulletC < W ) {
					if (map[bulletR][bulletC] == '*') {
						map[bulletR][bulletC] = '.';
						tf[bulletR][bulletC] = false;
						break;
					}else if (map[bulletR][bulletC] == '#') {
						break;
					}
				}else {
					break;
				}
			}
			
			return;
		}else if (order.equals("U")) {
			dir = 0;
		}else if (order.equals("D")) {
			dir = 1;	
		}else if (order.equals("L")) {
			dir = 2;	
		}else if (order.equals("R")) {
			dir = 3;
		}
		move();
	}
	
	public static void move() {

		if (pointR + dirR[dir] >= 0 && pointR + dirR[dir] < H && pointC + dirC[dir] >= 0 && pointC + dirC[dir] < W && !tf[pointR + dirR[dir]][pointC + dirC[dir]]) {
			map[pointR][pointC] = '.';
			pointR = pointR + dirR[dir];
			pointC = pointC + dirC[dir];
			if (dir == 0) {
				map[pointR][pointC] = '^';
			}else if (dir == 1) {
				map[pointR][pointC] = 'v';
			}else if (dir == 2) {
				map[pointR][pointC] = '<';
			}else if (dir == 3) {
				map[pointR][pointC] = '>';
			}
			
		}else {
			if (dir == 0) {
				map[pointR][pointC] = '^';
			}else if (dir == 1) {
				map[pointR][pointC] = 'v';
			}else if (dir == 2) {
				map[pointR][pointC] = '<';
			}else if (dir == 3) {
				map[pointR][pointC] = '>';
			}
		}
		
	}
	
}
