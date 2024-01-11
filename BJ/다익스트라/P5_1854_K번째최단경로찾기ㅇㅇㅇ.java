package BJ.다익스트라;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P5_1854_K번째최단경로찾기ㅇㅇㅇ{
    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        int N, M,K;
        int[][] W = new int[1001][1001]; // 이 문제는 인접행렬로, 인접 리스트가 아닌,
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N+1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2? 1 : -1;
            }
        };
        for(int i=0; i<N+1; i++){
            distQueue[i] = new PriorityQueue<Integer>(K, cp);
        }
        for(int i=0; i<M; i++){ // 인접 행렬에 그래프 데이터 저장
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            W[a][b] = c;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        distQueue[1].add(0);
        while (!pq.isEmpty()){
            Node u = pq.poll();
            for(int adjNode =1; adjNode<=N; adjNode++){
                // 연결된 모든 노드로 검색(시간 복잡도 측면에서 인접 행렬이 불리한 이유)
                if(W[u.node][adjNode] !=0){
                    // 저장된 경로가 K개가 안 될 때는 그냥 추가
                    if(distQueue[adjNode].size()<K){
                        distQueue[adjNode].add(u.cost+W[u.node][adjNode]);
                        pq.add(new Node(adjNode, u.cost+W[u.node][adjNode]));
                    }
                    // 저장된 경로가 K개이고, 현재 가장 큰 값보다 작을 때만 추가
                    else if(distQueue[adjNode].peek()>u.cost+W[u.node][adjNode]){
                        distQueue[adjNode].poll(); // 기존 큐에서 Max값 먼저 삭제
                        distQueue[adjNode].add(u.cost+W[u.node][adjNode]);
                        pq.add(new Node(adjNode, u.cost+W[u.node][adjNode]));
                    }
                }
            }
        }
        for(int i=1; i<=N; i++){ // K번째 경로 출력
            if(distQueue[i].size() == K){
                bw.write(distQueue[i].peek()+"\n");
            } else{
                bw.write(-1+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Node implements Comparable<Node>{

    int node;
    int cost;

    Node(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost<o.cost ? -1 : 1;
    }
}
