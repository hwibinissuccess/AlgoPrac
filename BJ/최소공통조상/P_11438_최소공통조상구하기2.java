package BJ.최소공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_11438_최소공통조상구하기2 {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int kmax;
    static int[][] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<N-1; i++){ // A인접 리스트에 그래프 데이터 저장하기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[N+1];
        visited = new boolean[N+1];
        int temp=1;
        kmax=0;
        while(temp<=N){ // 최대 가능 depth 구하기
            temp<<= 1;
            kmax++;
        }
        parent = new int[kmax+1];
    }
}
