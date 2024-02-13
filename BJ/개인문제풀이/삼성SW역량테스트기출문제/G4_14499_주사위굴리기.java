package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_14499_주사위굴리기 {
    static int N,M;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 주사위 면의 상태 - top up, down, left, right, bottom
        Dice curDice = new Dice(0,1,2,3,4,5);
        int[] dice = new int[6]; //주사위 각 면 값 저장할 배열

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int k = Integer.parseInt(st.nextToken());

            // 굴리기 전 현재 주사위 면 상태
            int t = curDice.top;
            int u = curDice.up;
            int d = curDice.down;
            int l = curDice.left;
            int r = curDice.right;
            int b = curDice.bottom;

            Dice nextDice;

            if(k==1){
                k=3;
                nextDice = new Dice(l,u,d,b,t,r);
            } else if(k==2){
                k=1;
                nextDice = new Dice(r,u,d,t,b,l);
            } else if(k==3){
                k=0;
                nextDice = new Dice(u,b,t,l,r,d);
            } else{
                k=2;
                nextDice = new Dice(d,t,b,l,r,u);
            }

            int nx = x+dx[k];
            int ny = y+dy[k];

            if(nx<0 || nx>=N || ny<0 || ny>=M){
                continue;
            }

            curDice = nextDice;
            x = nx;
            y = ny;

            if(map[nx][ny] == 0){
                map[nx][ny] = dice[nextDice.bottom];
                System.out.println(dice[nextDice.top]);
            } else{
                dice[nextDice.bottom] = map[nx][ny];
                map[nx][ny] =0;
                System.out.println(dice[nextDice.top]);
            }

        }

    }
}

class Dice{
    int top, up, down,left, right, bottom;

    public Dice(int top, int up, int down, int left, int right, int bottom) {
        this.top = top;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }
}
