package BJ.개인문제풀이.아직해결x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1697_숨바꼭질 {
    static int N, K;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = BFS(N);
        System.out.println(result);

    }

    public static int BFS(int node){
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        int index = node;
        int n=0;
        visit[index] = 1;
        while(!q.isEmpty()){
            n = q.poll();
            if(n==K){
                return visit[n]-1;
            }
            if(n-1>=0 && visit[n-1] == 0){
                visit[n-1] = visit[n]+1;
                q.add(n-1);
            }
            if(n+1<=100000 && visit[n+1]==0){
                visit[n+1] = visit[n]+1;
                q.add(n+1);
            }
            if(n*2<=100000 && visit[2*n] == 0){
                visit[2*n] = visit[n]+1;
                q.add(2*n);
            }
        }
        return -1;
    }

}
