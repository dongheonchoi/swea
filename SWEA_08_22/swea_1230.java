package SWEA_08_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_1230 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			LinkedList<Integer> link = new LinkedList<Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < n; i++) {				
				link.add(Integer.parseInt(st.nextToken()));
			}
			
			br.readLine();
			
			st = new StringTokenizer(br.readLine() , " ");
			
			while (st.hasMoreTokens()) {
				String command = st.nextToken();
			
				if (command.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int i = 0; i < y; i++) {
						link.add(x++, Integer.parseInt(st.nextToken()));	
					}
				}else if (command.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int i = 0; i < y; i++) {
						link.remove(x);
					}
				}else if (command.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for (int i = 0; i < y; i++) {
						link.add(Integer.parseInt(st.nextToken()));
					}
				}
				
			}

			
			sb.append("#"+tc);
			
			for (int i = 0; i < 10; i++) {
				sb.append(" " + link.pop());
			}
			sb.append("\n");
			
			
		}
		System.out.println(sb);

	}

}
