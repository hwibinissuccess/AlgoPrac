package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1_13460_구술탈출2 {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visit;
    static int holeX, holeY;
    static Marble blue, red;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M][N][M];

        // 구슬 map 입력받기
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);

                if(map[i][j] == '0'){
                    holeX = i;
                    holeY = j;
                } else if(map[i][j] == 'B'){
                    blue = new Marble(0,0,i,j,0);
                } else if(map[i][j] == 'R'){
                    red = new Marble(i,j,0,0,0);
                }
            }
        }
        System.out.println(BFS());
        br.close();
    }

    public static int BFS(){
        Queue<Marble> q = new LinkedList<>();
        q.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visit[red.rx][red.ry][blue.bx][blue.by] = true;

        while(!q.isEmpty()){
            Marble marble = q.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            if(curCnt > 10){
                return -1;
            }

            for(int i=0; i<4; i++){
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                // 빨간 구슬 이동 -> #벽을 만날때까지 이동
                while(map[newRx+dx[i]][newRy+dy[i]] != '#'){
                    newRx += dx[i];
                    newRy += dy[i];

                    // 구멍을 만날 경우
                    if(newRx == holeX && newRy == holeY){
                        isRedHole = true;
                        break;
                    }
                }
                // 파란 구슬 이동 -> 벽 만날때까지
                while(map[newBx+dx[i]][newBy+dy[i]] != '#'){
                    newBx += dx[i];
                    newBy += dy[i];

                    if(newBx == holeX && newBy == holeY){
                        isBlueHole = true;
                        break;
                    }
                }

                if(isBlueHole){
                    continue;
                }
                if(isRedHole && !isBlueHole){
                    return curCnt;
                }
                if(newRx == newBx && newRy == newBy){
                    if(i==0){
                        if(curRx > curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else if(i==1){
                        if(curRx < curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    } else if(i==2){
                        if(curRy<curBy) newRy -= dy[i];
                        else newBy -=  dy[i];
                    } else if(i==3){
                        if(curRy > curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }
                if(!visit[newRx][newRy][newBx][newBy]){
                    visit[newRx][newRy][newBx][newBy] = true;
                    q.add(new Marble(newRx, newRy, newBx, newBy, curCnt+1));
                }
            }

        }
        return -1;

    }

}

class Marble{
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    public Marble(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}
