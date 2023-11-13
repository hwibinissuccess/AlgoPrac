package BJ;

import java.util.*;

public class S2_1260_DFS와BFS프로그램 {

    static boolean visited[];
    static ArrayList<Integer>[] A;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();

        A = new ArrayList[N+1];
        for(int i=1; i<N; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(A[i]);
        }

        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        BFS(start);
        System.out.println();
    }

    public static void DFS(int node){
        System.out.println(node+" ");
        visited[node] = true;
        for(int i: A[node]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int now_node = queue.poll();
            System.out.println(now_node+" ");

            for(int i:A[node]){
                visited[i] = true;
                queue.add(i);
            }
        }
    }

}
