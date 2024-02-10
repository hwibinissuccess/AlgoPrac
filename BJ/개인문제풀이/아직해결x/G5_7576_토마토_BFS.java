package BJ.개인문제풀이.아직해결x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7576_토마토_BFS {
    static int[][] map;
    static int M,N;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<tomato> q = new LinkedList<tomato>();
    static StringTokenizer st;

    public static class tomato{
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.offer(new tomato(i,j,0));
                }
            }
        }
        BFS();
    }
    public static void BFS(){
        int day= 0;

        while(!q.isEmpty()){
            tomato t = q.poll();
            day = t.day;

            for(int i=0; i<4; i++){
                int nx = t.x+dx[i];
                int ny = t.y+dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = 1;
                        q.add(new tomato(nx,ny,day+1));
                    }
                }
            }
        }
        if(checkTomato()){
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static boolean checkTomato(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    return false;
                }
            }
            return true;
        }
    }

}
