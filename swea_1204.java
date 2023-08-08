import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1204 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < n; i++) {
			int testNum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int[] num = new int[101];
			for (int j = 0; j < 1000; j++) {
				num[Integer.parseInt(st.nextToken())]++;
			}
			
			int max = 0;
			int index = 0;
			for (int j = 0; j < 101; j++) {
				if (max <= num[j]) {
					max = num[j];	
					index = j;
				}
			}
			sb.append("#"+(i+1)+" "+ index).append("\n");
			
		}
		
        System.out.println(sb);
	}
}
