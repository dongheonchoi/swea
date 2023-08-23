package swea_08_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1232 {
	public static String[] arrstr;
	

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			arrstr = new String[N+1];
			
			for (int i = 1; i < N+1; i++) {
				arrstr[i] =br.readLine().split(" ",2)[1];
			}

			sb.append("#"+tc+ " " + (int)cal(arrstr[1])).append("\n");
						
		}
		System.out.println(sb);
		
	}
	public static float cal(String str) {
		StringTokenizer st = new StringTokenizer(str, " ");
		String first = st.nextToken();

		if (first.equals("+")) {	
			String second = st.nextToken();
			String third = st.nextToken();
			return cal(arrstr[Integer.parseInt(second)]) + cal(arrstr[Integer.parseInt(third)]);
		}else if (first.equals("-")) {
			String second = st.nextToken();
			String third = st.nextToken();
			return cal(arrstr[Integer.parseInt(second)]) - cal(arrstr[Integer.parseInt(third)]);
		}else if (first.equals("*")) {
			String second = st.nextToken();
			String third = st.nextToken();
			return cal(arrstr[Integer.parseInt(second)]) * cal(arrstr[Integer.parseInt(third)]);
		}else if (first.equals("/")) {
			String second = st.nextToken();
			String third = st.nextToken();
			return cal(arrstr[Integer.parseInt(second)]) / cal(arrstr[Integer.parseInt(third)]);
		}
		return Integer.parseInt(first);
	}
}
