import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1209 {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
          
        for(int tc = 1; tc <= 10; tc++){
            int a = Integer.parseInt(br.readLine());
             
            int[][] map = new int[100][100];
             
            int res = 0;
             
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for (int i = 0; i < 100; i++) { // 가로 합
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += map[i][j];
                }
                if (res < sum) {
                    res = sum;
                }
            }
             
             
            for (int i = 0; i < 100; i++) { // 세로 합
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += map[j][i];
                }
                if (res < sum) {
                    res = sum;
                }
            }
             
             
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += map[i][i];
            }
            if (res < sum) {
                res = sum;
            }
 
            sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += map[i][99 - i];
            }
            if (res < sum) {
                res = sum;
            }
             
 
             
             
            sb.append("#"+(tc)+" " + res).append("\n");
        }
        System.out.println(sb);
    }
}
