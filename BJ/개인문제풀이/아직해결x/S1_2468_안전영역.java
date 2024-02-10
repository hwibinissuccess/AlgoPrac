package BJ.개인문제풀이.아직해결x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2468_안전영역 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N,cnt,max_cnt;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int max_height=0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max_height < map[i][j]){
                    max_height = map[i][j];
                }
            }
        }
        max_cnt = 0;
        for(int h=0; h<=max_height; h++){
            visit = new boolean[N][N];
            cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]>h && !visit[i][j]){
                        cnt += DFS(i,j,h);
                    }
                }
            }
            max_cnt = Math.max(max_cnt,cnt);
        }
        System.out.println(max_cnt);
    }

    public static int DFS(int x, int y, int h){
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(!range_check(nx, ny) && map[nx][ny]>h && !visit[nx][ny]){
                DFS(nx,ny,h);
            }
        }
        return 1;
    }

    public static boolean range_check(int x, int y){
        return x<0 || y<0 || x>N-1 || y>N-1;
    }

}
