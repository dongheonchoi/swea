package swea_08_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1217 {
	public static int res; 
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb =new StringBuilder ();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			res = 1;
			recruit(n, m);
			sb.append("#" + tc +" "+ res +"\n");
		
		}
		System.out.println(sb);
	}
	public static void recruit(int n, int m) {
		if (m == 0) {
			return;
		}
		res *= n;
		recruit(n, m-1);
		
		
	}
	
	
}
