package swea_09_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class location{
	int r ,c;
	int time;
	
	public location(int r , int c) {
		this.r = r;    // 또 만들기 싫어서 가는데까지  걸리는 시간 까지 해주기
		this.c = c;	   
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
	
	
}

public class 점심식사시간 {
	
//	static int[][] map;
	
	static ArrayList<location> people;
	static ArrayList<location> time;
	static ArrayList<location> stair;
	
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
//					map[i][j] = num;
					if (num == 1) {
						location l = new location(i, j);
						people.add(l);
					}else if (num > 1) {
						location l = new location(i, j);	
						l.setTime(num);
						stair.add(l);
					}
					
				}
			}
			
			
			
			
			
			
		}
		

	}

}
