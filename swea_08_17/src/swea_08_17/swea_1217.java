package swea_08_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1217 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10 ; tc++) {
			br.readLine();
			String[] str = br.readLine().split(" ");
			int num = Integer.parseInt(str[0]);
			int n = Integer.parseInt(str[1]);
			sb.append("#" + tc + " " + pow(num,n)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	
	public static int pow(int num , int n) {
		if (n == 0) return 1;
		return num*pow(num , n-1);			
	}
	
}
