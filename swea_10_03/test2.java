package swea_10_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class test2 {
    static ArrayList<ArrayList<Integer>> vertax;
    static int[] verTaxCnt;
     
    static StringBuilder sb;
 
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        sb = new StringBuilder();
         
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine() ," ");
            sb.append("#" + tc);
             
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine(), " ");
             
            vertax = new ArrayList<>();
             
            for (int i = 0; i < V+1; i++) {
                ArrayList<Integer> a = new ArrayList<>();
                vertax.add(a);
            }
             
            verTaxCnt = new int[V+1];
             
            for (int i = 0; i < E; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                 
                vertax.get(from).add(to);
                verTaxCnt[to]++;
            }
            verTaxCnt[0] = -1;
             
            fn();
             
            sb.append("\n");
             
             
        }
        System.out.println(sb);
         
         
    }
     
    static void fn() {
        Queue<Integer> que = new LinkedList<Integer>();
         
         
        for (int i = 0; i < verTaxCnt.length; i++) {
            if (verTaxCnt[i] == 0) {
                que.add(i);
                sb.append(" "+i);
            }
        }
         
        while (!que.isEmpty()) {
            int a = que.poll();
            ArrayList<Integer> arr = vertax.get(a);
             
            for (int i = 0; i < arr.size(); i++) {
                int idx = arr.get(i);
                if (--verTaxCnt[idx] == 0) {
                    que.add(idx);
                    sb.append(" "+idx);
                }
            }
        }
    }
}