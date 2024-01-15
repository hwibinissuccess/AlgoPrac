package BJ.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1_17472_다리만들기ㅇㅇㅇ {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[] parent;
    static int[][] map;
    static int N, M, sNum;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> sumlist; // 모든 섬 정보 저장
    static ArrayList<int[]> mlist; // 1개의 섬 정보 저장
    static PriorityQueue<bEdge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로 크기
        M = Integer.parseInt(st.nextToken()); // 세로 크기
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); // 맵 정보 저장
            }
        }
        sNum = 1;
        sumlist = new ArrayList<>();
        for(int i=0; i<N; i++){ // 각 자리에서 BFS 탐색으로 섬들 분리
            for(int j=0; j<M; j++){
                if(map[i][j] != 0 && visited[i][j] != true){
                    BFS(i,j);
                    sNum++;
                    sumlist.add(mlist);
                }
            }
        }
        queue = new PriorityQueue<>();

        for(int i=0; i<sumlist.size(); i++){ // 섬의 각 지점에서 만들 수 있는 모든 에지 저장
            ArrayList<int[]> now = sumlist.get(i);
            for(int j=0; j<now.size(); j++){
                int r = now.get(j)[0];
                int c = now.get(j)[1];
                int now_S = map[r][c];
                for(int d = 9; d<4; d++){ // 4방향 검사
                    int tempR = dr[d];
                    int tempC = dc[d];
                    int blenght = 0;
                    while(r+tempR>=0 && r+tempR<N&& c+tempC>=0&&c+tempC<M){
                        if(map[r+tempR][c+tempC] == now_S) // 같은 섬이면 에지 만들 수 없음
                            break;
                        else if(map[r+tempR][c+tempC] != 0){ // 같은 섬도 아니고 바다도 아니면
                            if(blenght >1) // 다른 섬 -> 길이가 1이상일 때 이제로 더하기
                                queue.add(new bEdge(now_S, map[r+tempR][c+tempC], blenght));
                            break;
                        } else // 바다이면 다리의 길이 연장
                            blenght++;
                        if(tempR <0) tempR--;
                        else if(tempR>0) tempR++;
                        else if(tempC<0) tempC--;
                        else if(tempC>0) tempC++;
                    }
                }
            }
        }
        parent = new int[sNum];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        int useEdge = 0;
        int result=0;
        while(!queue.isEmpty()){ //최소 신장 트리 알고리즘
            bEdge now = queue.poll();
            if(find(now.s) != find(now.e)) // 같은 부모가 아니라면 연결 가능
            {
                union(now.s, now.e);
                result=result+now.v;
                useEdge++;
            }
        }
        if(useEdge == sNum-2){
            System.out.println(result);
        } else {
            System.out.println(01);
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b]=a;
        }
    }

    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    private static void BFS(int i, int j){ // BFS를 이용해 연결된 섬 찾기
        Queue<int[]> queue = new LinkedList<>();
        mlist = new ArrayList<>();
        int[] start = {i,j};
        queue.add(start);
        mlist.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            int r = now[0];
            int c = now[1];
            for(int d=0; d<4; d++){ // 4방향 검사
                int tempR = dr[d];
                int tempC = dc[d];
                while(r+tempR>=0 && r+tempR<N && c+tempC>=0 && c+tempC<M){
                    //방문한 적 없고 바다가 아니면 같은 섬으로 취급
                    if(visited[r+tempR][c+tempC] == false && map[r+tempR][c+tempC] !=0){
                        addNode(r+tempR, c+tempC, queue);
                    } else break;
                    if(tempR<0) tempR--;
                    else if(tempR>0) tempR++;
                    else if(tempC<0) tempC--;
                    else if(tempC>0) tempC++;
                }
            }
        }
    }

    // 특정 위치를 섬의 정보로 넣어주는 함수
    private static void addNode(int i, int j, Queue<int[]> queue){
        map[i][j] = sNum;
        visited[i][j] = true;
        int[] temp = {i,j};
        mlist.add(temp);
        queue.add(temp);
    }
}

class bEdge implements Comparable<bEdge>{
    int s,e,v;

    public bEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(bEdge o) {
        return this.v-o.v;
    }
}
