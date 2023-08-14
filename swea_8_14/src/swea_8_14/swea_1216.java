package swea_8_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1216 {

	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			String str = br.readLine();
			String[] strArr = ("--" + br.readLine() +  "--").split(str);
			
			sb.append("#"+ tc + " " + (strArr.length-1)).append("\n");
		}
		System.out.println(sb);
	}
	
	
	
	
}
