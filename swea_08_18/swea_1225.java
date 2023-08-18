package swea_08_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1225 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Queue<Integer> que = new LinkedList<Integer>();
			
			for (int i = 0; i < 8; i++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean flag = true;
			int minus = 1;
			int num = 0;
			while (flag) {
				num = que.poll();
				num -= minus++;
				if (num <= 0) {
					num = 0;
					flag =false;
				}
				que.add(num);	
				if (minus == 6) {
					minus = 1;
				}
			} 
			sb.append("#"+tc);
			
			for (int i = 0; i < 8; i++) {
				sb.append(" " + que.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}

}
