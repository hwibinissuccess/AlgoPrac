package BJ.개인문제풀이.아직해결x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1_1697_숨바꼭질_BFS {
    static int N,K;
    static int visit[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");

        N = Integer.valueOf(inputs[0]);
        K = Integer.valueOf(inputs[1]);

        int result = BFS(N);
        System.out.println(result);
    }

    private static int BFS(int node){
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(node);
        int index = node;
        int n=0;
        visit[index] = 1;
        while(!q.isEmpty()){
            n = q.remove();

            if(n == K){
                return visit[n]-1;
            }
            if(n-1>=0 && visit[n-1]==0){
                visit[n-1] = visit[n]+1;
                q.add(n-1);
            }
            if(n+1<=100000 && visit[n+1]==0){
                visit[n+1] = visit[n]+1;
                q.add(n+1);
            }
            if(n*2<=100000 && visit[n*2] == 0){
                visit[2*n] = visit[n]+1;
                q.add(n*2);
            }
        }
        return -1;
    }

}
