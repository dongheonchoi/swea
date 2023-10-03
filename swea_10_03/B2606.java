package swea_10_03;

import java.util.Scanner;

public class B2606 {

    public static int N;
    public static int[][] adjArr;
    public static boolean[] visit;
    public static int count = 1;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        
        adjArr = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            adjArr[A][B] = adjArr[B][A] = 1;
        }
        
        visit = new boolean[N+1];
        DFS(1);
        System.out.println(count);
    }

    public static void DFS(int v) {
        visit[v] = true;
        
        for(int i = 1; i < N+1; i++) {
            if(!visit[i] && adjArr[v][i] == 1) {
                count++;
                visit[i] = true;
            }
        }
    }
}
