package swea_08_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1231 {
	
	public static String[] arr; 
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
				
			arr = new String[N+1]; 
			for (int i = 1; i <= N; i++) {
				arr[i] = br.readLine().split(" " , 2)[1];
			}
			sb.append("#"+tc+" ");
			sol(1);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

	public static void sol(int i) {
		StringTokenizer st = new StringTokenizer(arr[i], " ");
		String s = st.nextToken();
		if (st.hasMoreTokens()) {
			sol(Integer.parseInt(st.nextToken()));
			sb.append(s);
			if (st.hasMoreTokens()) {
				sol(Integer.parseInt(st.nextToken()));				
			}
		}else {
			sb.append(s);
		}		
	}

}
