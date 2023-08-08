import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1208 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int[] arr = new int[100];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);

			int cnt = 0;
			
			flag:
			for (int j = 0; j < 100; j++) {
				for (int j2 = 98; j2 >= 0; j2--) {
					if (arr[j2] == arr[arr.length-1]) {
						arr[j2]--;
						cnt++;
					}else {
						break;
					}
					if (cnt == a) {
						break flag;
					}				
				}
				arr[arr.length-1]--;
				cnt++;
				if (cnt == a) {
					break flag;
				}
			}
			
			
			Arrays.sort(arr);
			
			flag2:
			while (true) {
				for (int j = 1; j < 100; j++) {
					if (arr[0] == arr[j]) {
						arr[j]++;
						cnt--;
					}else {
						break;
					}
					if (cnt == 0) {
						break flag2;
					}
				}
				arr[0]++;
				cnt--;
				if (cnt == 0) {
					break flag2;
				}	
			}
			
			Arrays.sort(arr);
			
			int res = arr[arr.length-1] - arr[0];
			
			sb.append("#"+(i+1)+" "+ res).append("\n");

		}
		System.out.println(sb);
        
	}
}
