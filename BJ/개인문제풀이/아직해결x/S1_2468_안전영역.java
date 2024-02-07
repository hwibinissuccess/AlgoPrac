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
    static int N, max_height,cnt;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        max_height = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > max_height){
                    max_height = map[i][j];
                }
            }
        } // 입력완료

        int max=0;
        for(int h=0; h<max_height; h++){
            visit = new boolean[N][N];
            cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visit[i][j] && map[i][j] > h){
                        cnt++;
                        DFS(i,j,h);
                        max = Math.max(max, cnt);
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static void DFS(int x, int y, int h){
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(!range_check(nx, ny) && !visit[nx][ny] && map[nx][ny] > h){
                DFS(nx, ny, h);
            }
        }
    }

    public static boolean range_check(int x, int y){
        return x<0 || y<0 || x>=N || y>=N;
    }

}
