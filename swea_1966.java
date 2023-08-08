import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1966 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < n; i++) {
			int testLen = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int[] num = new int[testLen];
			for (int j = 0; j < testLen; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			
			int temp;
			
			for (int j = 0; j < num.length-1; j++) {
				for (int j2 = 0; j2 < num.length-1-j; j2++) {
					if (num[j2] > num[j2+1]) {
						temp = num[j2];
						num[j2] = num[j2+1];
						num[j2+1] = temp;
					}
				}
			}

			sb.append("#"+(i+1));
			for (int j = 0; j < num.length; j++) {
				sb.append(" " + num[j]);
			}
			sb.append("\n");
		}
		
        System.out.println(sb);
	}
}
