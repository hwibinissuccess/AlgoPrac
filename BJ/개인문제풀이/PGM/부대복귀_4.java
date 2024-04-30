package BJ.개인문제풀이.PGM;

import java.util.*;

public class 부대복귀_4 {

    static List<List<Integer>> graph;
    static int[] dis;
    static int MAX=Integer.MAX_VALUE;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        graph = new ArrayList<>();

        for(int i=0; i<n+1; i++) graph.add(new ArrayList<>());

        for(int[] road : roads){

            int s = road[0];
            int e = road[1];

            graph.get(s).add(e);
            graph.get(e).add(s);

        }

        dis = new int[n+1];

        Arrays.fill(dis,MAX);
        dks(destination);

        int[] ans = new int[sources.length];

        for(int i=0; i<sources.length; i++){
            ans[i] = (dis[sources[i]]<MAX) ? dis[sources[i]] : -1;
        }

        return ans;
    }

    public static void dks(int destination){

        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        dis[destination] = 0;

        while(!q.isEmpty()){

            int cn = q.poll();

            for(int i=0; i<graph.get(cn).size(); i++){

                int nn = graph.get(cn).get(i);

                if(dis[nn] > dis[cn]+1){
                    dis[nn] = dis[cn]+1;
                    q.add(nn);
                }

            }

        }

    }

}
