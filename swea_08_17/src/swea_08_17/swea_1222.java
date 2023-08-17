package swea_08_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class swea_1222 { // 계산기1

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10 ; tc++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<String> sta = new Stack();
			Queue<String> que = new LinkedList();
			
			
			for (int i = 0; i < len; i++) {
				if (i%2 == 0) {
					que.add(str.charAt(i)+"");
				}else{
					if (sta.empty()) {
						sta.add(str.charAt(i)+"");						
					}else{
						que.add(sta.pop()+"");
						sta.add(str.charAt(i)+"");
					}
				}
			}
			while (!sta.empty()) {
				que.add(sta.pop()+"");
			}

		
			while (!que.isEmpty()) {
				String cha = que.poll();
				if (cha.equals("+")) {
					int a = Integer.parseInt(sta.pop());
					int b = Integer.parseInt(sta.pop());
					a += b;
					sta.add(a+"");
				}else {
					sta.push(cha);
				}
			}

			
			sb.append("#" + tc + " " + sta.pop()).append("\n");
		}
		System.out.println(sb);
	}
	
}
