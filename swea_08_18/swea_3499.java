package swea_08_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_3499 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= test_case; tc++) {
			int num = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			Queue<String> que1 = new LinkedList();
			Queue<String> que2 = new LinkedList();
			
			for (int i = 0; i < num; i++) {
				if (i < Math.round((double)num/2)) {
					que1.add(st.nextToken());					
				}else {
					que2.add(st.nextToken());										
				}
			}
			sb.append("#"+tc);
			
			for (int i = 0; i < num; i++) {
				if (i%2 == 0) {
					sb.append(" " + que1.poll());
				}else {
					sb.append(" " + que2.poll());					
				}
		
			}
			sb.append("\n");
		}
		System.out.println(sb);		
	}

}
