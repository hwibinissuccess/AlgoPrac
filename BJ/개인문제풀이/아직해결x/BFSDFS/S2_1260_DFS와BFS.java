package BJ.개인문제풀이.아직해결x.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1260_DFS와BFS{
    static boolean[] visit;
    static int[][] map;
    static int N,M,V;
    static StringTokenizer st;
    static List<Integer> dfs;
    static List<Integer> bfs;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new boolean[N];
        dfs = new LinkedList();
        bfs = new LinkedList();
        q = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s][e] = map[e][s] = 1;
        } // 입력완료

        // DFS
        DFS(1);
        System.out.println();
        visit = new boolean[N];
        // BFS
        BFS(1);
    }

    public static void DFS(int x){
        visit[x] = true;
        System.out.print(x);

        for(int i=0; i<=N; i++){
            if(map[x][i] == 1 && !visit[i])
                DFS(i);
        }
    }

    public static void BFS(int x){
        q.add(x);
        visit[x] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now);
            for(int i=1; i<=N; i++){
                if(map[now][i] == 1 && !visit[i]){
                    q.add(i);
                    visit[i] = true;
                }
            }
        }
    }

}
