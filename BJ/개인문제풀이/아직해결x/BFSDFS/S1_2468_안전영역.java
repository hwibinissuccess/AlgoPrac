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
    static int N, cnt, max_height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        max_height = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max_height < map[i][j]){
                    max_height = map[i][j];
                }
            }
        } // 입력 받기

        int max=0;
        for(int h=0; h<max_height+1; h++){
            visit = new boolean[N][N];
            cnt =0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j] && map[i][j] >h){
                        cnt +=  DFS(i,j,h);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
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
