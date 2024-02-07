package BJ.개인문제풀이.해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G5_10026_적록색약 {
    static char[][] map;
    static boolean[][] visit;
    static int N, normalCnt, colorCnt;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];
        for(int i=0; i<N; i++){
            s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j);
            }
        } // 입력받기 완료

        // 정상 경우
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    normalCnt++;
                    DFS(i,j);
                }
            }
        }

        // 비정상 경우
        visit = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'R'){
                    map[i][j] = 'G';
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    colorCnt++;
                    DFS(i,j);
                }
            }
        }

        System.out.println(normalCnt + " "+ colorCnt);

    }

    public static void DFS(int x, int y){
        visit[x][y]=true;
        char temp = map[x][y];

        for(int i=0; i<4; i++){
            int nowX = x+dx[i];
            int nowY = y+dy[i];

            if(!range_check(nowX, nowY) && !visit[nowX][nowY] && map[nowX][nowY]==temp){
                DFS(nowX, nowY);
            }

        }
    }

    public static boolean range_check(int x , int y){
        return x<0 || y<0 || x>=N || y>=N;
    }

}
