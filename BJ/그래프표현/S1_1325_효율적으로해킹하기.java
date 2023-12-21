package BJ.그래프표현;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1325_효율적으로해킹하기 {
    static int N, M;
    static boolean visited[];
    static int answer[];
    static ArrayList<Integer> A[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        answer = new int[N+1];
        for(int i=1; i<=N; i++)
            A[i] = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }
        for(int i=1; i<=N; i++){ // 모든 노드로 BFS 실행
            visited = new boolean[N+1];
            BFS(i);
        }
        int maxVal=0;
        for(int i=1; i<=N; i++){
            maxVal = Math.max(maxVal,answer[i]);
        }
        for(int i=1; i<=N; i++){
            if(answer[i] == maxVal){ // answer배열에서 maxVal과 같은 값을 지닌 index가 정답
                System.out.println(i+" ");
            }
        }
    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(int i:A[now_node]){
                if(visited[i] == false){
                    visited[i]=true;
                    answer[i]++; // 신규 노드 인덱스의 정답 배열 값을 증가
                    queue.add(i);
                }
            }
        }
    }
}
