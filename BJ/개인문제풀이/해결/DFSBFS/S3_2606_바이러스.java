package BJ.개인문제풀이.해결.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2606_바이러스 {
    static int[][] map;
    static boolean[] visit;
    static int N, line, cnt;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visit = new boolean[N+1];
        cnt = 0;

        for(int i=0; i<line; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s][e] = map[e][s] = 1;

        } // 입력완료

        DFS(1);

        System.out.println(cnt);

    }

    public static void DFS(int x){
        visit[x] = true;

        for(int i=1; i<=N; i++){
            if(map[x][i] == 1 && !visit[i]){
                cnt++;
                DFS(i);
            }
        }
    }

}
