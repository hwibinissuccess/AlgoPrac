package BJ.개인문제풀이.알고리즘kit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {

    static ArrayList<Integer>[] adj;
    static int[] visit;
    static int depth=0;

    public int solution(int n, int[][] edge) {

        int ans=0;
        visit = new int[n+1];
        adj = new ArrayList[n+1];

        for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<edge.length; i++){
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }

        BFS(1,1);

        for(int i=1; i<=n; i++){
            if(depth==visit[i]) ans +=1;
        }

        return ans;

    }

    public static void BFS(int start, int cnt){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        q.add(cnt);
        visit[start] = cnt;

        while(!q.isEmpty()){
            int node = q.poll();
            int n = q.poll();

            if(depth < n ) depth = n;

            for(int i=0; i<adj[node].size(); i++){
                int next = adj[node].get(i);

                if(visit[next] != 0) continue;
                visit[next] = n+1;
                q.add(next);
                q.add(n+1);
            }
        }
    }

}
