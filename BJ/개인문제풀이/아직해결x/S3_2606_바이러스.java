package BJ.개인문제풀이.아직해결x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_2606_바이러스 {
    static int[][] map;
    static boolean[] visit;
    static Queue<Integer> q = new LinkedList<>();
    static int cnt=0;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        map = new int[C+1][C+1];
        visit = new boolean[C+1];

        for(int i=0; i<line; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s][e] = 1;
            map[e][s] = 1;
        }
        DFS(1);
        System.out.println(cnt);
    }
    private static void DFS(int start){
        visit[start] = true;
        cnt++;

        for(int i=0; i<=C; i++){
            if(map[start][i] == 1&&!visit[i]){
                DFS(i);
            }
        }
    }
}
