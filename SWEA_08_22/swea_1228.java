package SWEA_08_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_1228 {

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
			
			int order = Integer.parseInt(br.readLine()); 
			
			st = new StringTokenizer(br.readLine() , "I");
			
			for (int i = 0; i < order; i++) {
				StringTokenizer st2 = new StringTokenizer(st.nextToken(), " ");
				int point = Integer.parseInt(st2.nextToken());
				
				int num = Integer.parseInt(st2.nextToken());
				
				for (int j = 0; j < num; j++) {
					link.add(point++, Integer.parseInt(st2.nextToken()));
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
