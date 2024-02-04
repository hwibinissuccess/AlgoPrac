package BJ.개인문제풀이.아직해결x;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class S1_2667_단지번호붙이기 {
    static int[][] danji;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static List<Integer> result;
    static int cnt, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        result = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        danji = new int[N][N];
        visit = new boolean[N][N];
        cnt=1;

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                danji[i][j] = str.charAt(j)-'0';
            }
        }

        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(danji[x][y]==1 && !visit[x][y]){
                    dfs(x,y);
                    result.add(cnt);
                    cnt=1;
                }
            }
        }

        Collections.sort(result);

        bw.write(result.size()+"\n");
        for(int r: result) bw.write(r+"\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y){
        visit[x][y]= true;

        for(int i=0; i<4; i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny] && danji[nx][ny] ==1){
                cnt++;
                dfs(nx, ny);
            }

        }
    }

}
