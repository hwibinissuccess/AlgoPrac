package BJ.개인문제풀이.해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_1012_유기농배추 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int T,M,N,K,X,Y,cnt;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T;tc++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M+1][N+1];
            visit = new boolean[M+1][N+1];
            cnt = 0;
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                map[X+1][Y+1] = 1;
            } // 입력완료

            for(int i=1; i<=M; i++){
                for(int j=1; j<=N; j++){
                    if(!visit[i][j] && map[i][j] == 1){
                        cnt++;
                        DFS(i,j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void DFS(int x, int y){
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(!range_check(nx,ny) && !visit[nx][ny] && map[nx][ny]==1){
                DFS(nx, ny);
            }
        }
    }

    public static boolean range_check(int x, int y){
        return x<0 || y<0 || x>M || y>N;
    }

}
