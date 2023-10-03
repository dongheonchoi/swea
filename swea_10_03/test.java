package swea_10_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test {

    static int[] dr = { 0, 1, 0, -1 }; // 우하상좌
    static int[] dc = { 1, 0, -1, 0 };

    static int N, cnt, ans;
    static int[][] adjArr;
    static boolean[][] vst;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        adjArr = new int[N][N];

        for (int r = 0; r < N; r++) {
            String[] str = sc.next().split("");

            for (int c = 0; c < N; c++) {
                adjArr[r][c] = Integer.parseInt(str[c]);
            }
        }

        vst = new boolean[N][N];
        
        List<Integer> list = new ArrayList<>();
        
        ans = 0;
        
        // 단지 수 찾기
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                
                if (!vst[r][c] && adjArr[r][c] == 1) {
                    cnt = 1;
                    vst[r][c] = true;
                    dfs(r, c);
                    list.add(cnt);
                    ans++;
                } 
            }
        }
        System.out.println(ans);
        
        Collections.sort(list);
        for(int i = 0; i < ans; i++) {
            System.out.println(list.get(i));
        }
        

    }

    public static void dfs(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || adjArr[nr][nc] == 0 || vst[nr][nc]) {
                continue;
            }
            vst[nr][nc] = true;
            cnt++;
            dfs(nr, nc);
        }
    }
}

