package BJ.개인문제풀이.PGM.해결;

import java.util.*;

public class 부대복귀 {

    static int[] dis;
    static int N;
    static List<List<Integer>> list;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        int ans[] = new int[sources.length];
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        N = n;
        list = new ArrayList<>();
        for(int i=0; i<=n; i++) list.add(new ArrayList<>());

        for(int i=0; i<roads.length; i++){

            int s = roads[i][0];
            int e = roads[i][1];

            list.get(s).add(e);
            list.get(e).add(s);

        }

        dks(destination);
        boolean flag = true;

        for(int i=0; i<sources.length; i++){
            ans[i] = dis[sources[i]] < Integer.MAX_VALUE ? dis[sources[i]] : -1;
        }

        return ans;

    }

    public static void dks(int start){

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dis[start] = 0;

        while(!q.isEmpty()){

            int now = q.poll();

            for(int i=0; i<list.get(now).size(); i++){

                int next = list.get(now).get(i);

                if(dis[next] > dis[now]+1){
                    dis[next] = dis[now]+1;
                    q.add(next);
                }

            }

        }

    }

}
