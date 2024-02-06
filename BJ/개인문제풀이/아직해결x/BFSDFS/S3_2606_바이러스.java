package BJ.개인문제풀이.아직해결x.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S3_2606_바이러스 {
    static boolean[] visit;
    static int[][] com;
    static int N,line,cnt,s,e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        com = new int[N+1][N+1];
        cnt=0;
        visit = new boolean[N+1];

        for(int i=0; i<line; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            com[s][e] = com[e][s] = 1;

        } // 입력받기

        DFS(1);

        System.out.println(cnt-1);

    }

    public static void DFS(int a){
        visit[a] = true;
        cnt++;
        for(int i=0; i<=N; i++){
            if(com[a][i] == 1 && !visit[i]){

                DFS(i);
            }
        }
    }

}
