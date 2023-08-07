import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2068 {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int val = 0;
         
        for(int i = 0; i < a; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int max = 0;
             
            for(int j = 0; j < 10; j++){
                val = Integer.parseInt(st.nextToken());
                if(max < val){
                    max = val;
                }
            }
            sb.append("#"+(i+1)+" "+ max).append("\n");
//            System.out.println("#"+(i+1)+" "+ max);
        }
        System.out.println(sb);
        
	}
}
