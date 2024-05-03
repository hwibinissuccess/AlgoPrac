package BJ.개인문제풀이.PGM;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 합승택시요금_5 {

    int N;
    int E;
    int[][] matrix;

    public int solution(int n, int s, int a, int b, int[][] fares) {

        N = n;
        E = fares.length;
        matrix = new int[n][n];

        for(int i=0; i<E; i++){

            int u = fares[i][0]-1;
            int v = fares[i][1]-1;
            int cost = fares[i][2];

            matrix[u][v] = cost;
            matrix[v][u] = cost;

        }

        int[] together = dks(s-1);
        int minCost = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            int[] alone = dks(i);

            int cost = together[i]+alone[a-1]+alone[b-1];

            if(cost<minCost){
                minCost=cost;
            }
        }

        return minCost;

    }

    public int[] dks(int start){

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        boolean[] visit = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        q.add(new int[]{0,start});

        while(!q.isEmpty()){

            int[] cur = q.remove();
            int u = cur[1];
            if(visit[u]){
                continue;
            }

            visit[u] = true;

            for(int v=0; v<N; v++){
                if(matrix[u][v] == 0){
                    continue;
                }

                if(distance[u] + matrix[u][v] < distance[v]){
                    distance[v] = distance[u]+matrix[u][v];
                    q.add(new int[]{distance[v],v});
                }

            }

        }

        return distance;

    }

}
