package BJ.개인문제풀이.아직해결x;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class S1_2667_단지번호붙이기 {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N, homeCnt;
    static List<Integer> cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        homeCnt = 1;
        cnt = new LinkedList<>();

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = s.charAt(j) -'0';
            }
        } // 입력완료

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j] && map[i][j] ==1){
                    DFS(i,j);
                    cnt.add(homeCnt);
                    homeCnt = 1;
                }
            }
        }
        Collections.sort(cnt);
        bw.write(cnt.size()+"\n");
        for(int r : cnt) bw.write(r+"\n");
        bw.flush();
        bw.close();
    }

    public static void DFS(int x, int y){
        visit[x][y] = true;


        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(!range_check(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1){
                homeCnt++;
                DFS(nx, ny);
            }
        }
    }

    public static boolean range_check(int x, int y){
        return x<0 || y<0 || x>=N || y>=N;
    }

}
