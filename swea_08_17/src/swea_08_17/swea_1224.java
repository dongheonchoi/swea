package swea_08_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class swea_1224 { // 계산기3

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10 ; tc++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<String> sta = new Stack();
			Queue<String> que = new LinkedList();
			
			Map<String,Integer> isp = new HashMap();
			isp.put("*", 2);	isp.put("/", 2);
			isp.put("+", 1);	isp.put("-", 1);
			isp.put("(", 0);
			Map<String,Integer> icp = new HashMap();
			icp.put("*", 2);	icp.put("/", 2);
			icp.put("+", 1);	icp.put("-", 1);
			icp.put("(", 3);
			
			
			for (int i = 0; i < len; i++) {
				if ((str.charAt(i)+"").matches("^[0-9]*$")) {
					que.add(str.charAt(i)+"");
				}else if(str.charAt(i) != ')'){
					if (!sta.isEmpty()) {
						while (isp.get(sta.peek()) > icp.get(str.charAt(i)+"")) {
							que.add(sta.pop());	
						}						
					}
					sta.add(str.charAt(i)+"");
				}else if (str.charAt(i) == ')') {
					while (!sta.peek().equals("(")) {
						que.add(sta.pop());	
					}
					sta.pop();
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
				}else if (cha.equals("-")) {
					int a = Integer.parseInt(sta.pop());
					int b = Integer.parseInt(sta.pop());
					a -= b;
					sta.add(a+"");
				}else if (cha.equals("*")) {
					int a = Integer.parseInt(sta.pop());
					int b = Integer.parseInt(sta.pop());
					a *= b;
					sta.add(a+"");
				}else if (cha.equals("/")) {
					int a = Integer.parseInt(sta.pop());
					int b = Integer.parseInt(sta.pop());
					a /= b;
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
