import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_16504 {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int i = 0; i < T; i++){
            int len = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int[] box = new int[len];
        	for (int j = 0; j < box.length; j++) {
				box[j] = Integer.parseInt(st.nextToken());
			}
        	
        	int sum = -1;
        	int max = 0;
        	int temp = 0;

        	while (sum != 0) {
        		sum = 0;
        		temp = 0;
				boolean flag = false;
				for (int j = 0; j < box.length; j++) {
					if (box[j] != 0) {
						box[j]--;
						sum++;
						flag = true;
					}else if(flag && box[j] == 0) {
						temp ++;
					}
				}
				if (temp > max) {
					max = temp;
				}

			}
        	
        	sb.append("#"+(i+1)+" "+ max).append("\n");
        	
        }
        System.out.println(sb);
	}
}
