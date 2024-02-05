package BJ.개인문제풀이.아직해결x.BFSDFS;

import java.util.Scanner;

public class S2_11724_연결요소의개수 {
    static int[][] graph = new int[1001][1001];
    static int V, E;
    static boolean[] visited = new boolean[1001];

    public static void dfs(int index){
        if(visited[index]==true)
            return;
        else {
            visited[index] = true;
            for(int i=1; i<=V; i++){
                if(graph[index][i]==1){
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V= sc.nextInt();
        E= sc.nextInt();

        int a,b;
        for(int i=0; i<E; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            graph[a][b] = graph[b][a] = 1;
        }
        int result=0;

        //dfs
        for(int i=1; i<=V; i++){
            if(visited[i] == false){ // 방문한적 없는 노드라면
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

}
