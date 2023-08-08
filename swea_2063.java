import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2063 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] score = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			
			score[i] = Integer.parseInt(st.nextToken());

		}
		int temp;
		
		for (int j = 0; j < score.length-1; j++) {
			for (int j2 = 0; j2 < score.length-1-j; j2++) {
				if (score[j2] > score[j2+1]) {
					temp = score[j2];
					
					score[j2] = score[j2+1];
					score[j2+1] = temp;
				}
			}
		}
		
		System.out.println(score[n/2]);
		
		
	}
}
