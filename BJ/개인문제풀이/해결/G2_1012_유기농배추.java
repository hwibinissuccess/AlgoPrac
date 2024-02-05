package BJ.개인문제풀이.해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_1012_유기농배추 {
    static int[][] map;
    static boolean[][] visit;
    static int T,M,N,K,X,Y;
    static int cnt;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st  = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visit = new boolean[M][N];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                map[X][Y] = 1;
            }
            cnt = 0;

            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j] && map[i][j] == 1){
                        cnt++;
                        DFS(i,j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void DFS(int x, int y){
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int nowX = dx[i]+x;
            int nowY = dy[i]+y;

            if(range_check(nowX, nowY) && !visit[nowX][nowY] && map[nowX][nowY] == 1){
                DFS(nowX, nowY);
            }

        }

    }

    private static boolean range_check(int nowX, int nowY){
        return (nowX>=0 && nowY>=0 && nowX<M && nowY<N);
    }

}
