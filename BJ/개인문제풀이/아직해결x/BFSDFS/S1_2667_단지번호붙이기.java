package BJ.개인문제풀이.아직해결x.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S1_2667_단지번호붙이기 {
    static int[][] map;
    static boolean[][] visit;
    static int N, cityCnt,cnt;
    static ArrayList homeCnt;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력받기
        cityCnt =0;
        homeCnt = new ArrayList();
        for(int i=0; i<N; i++){
            cnt = 0;
            for(int j=0; j<N; j++){
                if(!visit[i][j] && map[i][j]==1){
                    cityCnt++;
                    DFS(i,j);
                    homeCnt.add(cnt);
                }
            }
        }
        Collections.sort(homeCnt);
        System.out.println(cityCnt);
        for(int i=0; i<homeCnt.size(); i++){
            if(!homeCnt.get(i).equals(0)){
                System.out.println(homeCnt);
            }
        }
    }
    public static void DFS(int x, int y){
        visit[x][y] = true;
        cnt++;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(!range_check(nx, ny) && !visit[nx][ny] && map[nx][ny] ==1){
                DFS(nx, ny);
            }
        }
    }
    public static boolean range_check(int x, int  y){
        return x<0 || y<0 || x>=N || y>=N;
    }
}
