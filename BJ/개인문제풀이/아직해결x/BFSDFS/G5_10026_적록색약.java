package BJ.개인문제풀이.아직해결x.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_10026_적록색약 {
    static char[][] map;
    static boolean[][] visit;
    static int N, normalCnt, colorCnt;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // map크기
        normalCnt = 0;
        colorCnt = 0; // 카운트 초기화
        map = new char[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            S = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = S.charAt(j);
            }
        } // map 입력받기

        // 정상 경우
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    DFS(i,j);
                    normalCnt++;
                }
            }
        }

        // 비정상 경우
        visit = new boolean[N+1][N+1];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    DFS(i,j);
                    colorCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + colorCnt);

    }

    public static void DFS(int x, int y){

        visit[x][y] = true;
        char temp_char = map[x][y];
        for(int i=0; i<4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            if(newX<0 || newY<0 || newX>N || newY > N){
                continue;
            }

            if(!visit[newX][newY] && map[newX][newY] == temp_char){
                DFS(newX, newY);
            }

        }

    }

}
