package BJ.개인문제풀이.PGM;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 배달_1 {

    static int[] dist;
    static boolean[] visit;
    static ArrayList<ArrayList<Node>> graph;

    public int solution(int N, int[][] road, int K) {

        int ans = 0;
        dist = new int[N+1];
        visit = new boolean[N+1];
        graph = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] r : road){
            graph.get(r[0]).add(new Node(r[1],r[2]));
            graph.get(r[1]).add(new Node(r[0],r[2]));
        }
        for(int i=0; i<dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        dks(1);

        for(int i=0; i<dist.length; i++){
            if(dist[i] <= K) ans++;
        }

        return ans;
    }

    public static class Node{

        int n;
        int cost;

        public Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }
    }

    public static void dks(int start){

        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Node(start, 0));

        while(!q.isEmpty()){

            Node curNode = q.poll();

            if(dist[curNode.n] < curNode.cost) continue;

            for(int i=0; i<graph.get(curNode.n).size(); i++){

                Node nextNode = graph.get(curNode.n).get(i);
                if(dist[nextNode.n] > curNode.cost + nextNode.cost){
                    dist[nextNode.n] = curNode.cost + nextNode.cost;
                    q.add(new Node(nextNode.n, dist[nextNode.n]));
                }
            }
        }
    }
}
