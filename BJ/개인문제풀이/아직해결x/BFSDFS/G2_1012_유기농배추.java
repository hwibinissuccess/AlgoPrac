package BJ.개인문제풀이.아직해결x.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_1012_유기농배추 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int T, M, N, K, X, Y, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cnt=0;
            map = new int[M][N];
            visit = new boolean[M][N];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                map[X][Y] = 1;
            } // 입력받기 완료

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j] && map[i][j] == 1){
                        DFS(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }

    public static void DFS(int x, int y){
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            if(!range_check(newX, newY) && !visit[newX][newY] && map[newX][newY] == 1){
                DFS(newX, newY);
            }

        }
    }

    public static boolean range_check(int x, int y){
        return x < 0 || y < 0 || x >= M || y >= N;
    }

}
