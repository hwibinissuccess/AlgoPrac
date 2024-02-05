package BJ.개인문제풀이.아직해결x.BFSDFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2468_안전영역 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        cnt = 0;
        int maxHeight=0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]> maxHeight){
                    maxHeight = map[i][j];
                }
            }
        } // 입력 끝

        int max=0;
        // 모든 지역 탐색
        for(int height=0; height<maxHeight+1;height++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    // 안전 영역 탐지
                    if(!visit[i][j] && map[i][j]>height)
                    cnt+=DFS(i,j,height); // 해당 안전영역 탐색 시작
                }
            }
        }
        max=Math.max(max, cnt);
        System.out.println(max);
    }

    static int DFS(int x, int y, int height){
        visit[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||ny<0||nx>N-1||ny>N-1) continue;
            if(visit[nx][ny]) continue;
            if(map[nx][ny]>height){
                DFS(nx, ny, height);
            }
        }
        return 1;
    }
}
