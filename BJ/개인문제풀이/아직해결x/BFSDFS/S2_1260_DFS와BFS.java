package BJ.개인문제풀이.아직해결x.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1260_DFS와BFS {
    static boolean[] visit;
    static int[][] map;
    static int N, M, V;
    static StringTokenizer st;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        map = new int[N + 1][N + 1];


        for (int j = 1; j <= M; j++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s][e] = map[e][s] = 1;
        } // 입력 완료

        DFS(V);

        BFS(V);

    }

    public static void DFS(int v) {
        visit[v] = true;
        System.out.println(v + " ");
        for (int i = 1; i < N + 1; i++) {
            if (!visit[i] && map[v][i] == 1) {
                DFS(i);
            }
        }

    }

    public static void BFS(int v) {
        q = new LinkedList<>();
        q.add(v);
        System.out.println(v + " ");
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i < N + 1; i++) {
                if (!visit[i] && map[now][i] == 1) {
                    q.add(i);
                    visit[i] = true;
                }
            }
        }

    }

}
