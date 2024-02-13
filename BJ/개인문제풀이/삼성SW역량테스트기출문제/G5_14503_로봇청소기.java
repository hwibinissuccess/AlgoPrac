package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.util.Scanner;

public class G5_14503_로봇청소기 {
    static int N,M,r,c,d;
    static int[][] arr;
    static int cnt=1;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        clean(r,c,d);
        System.out.println(cnt);
    }

    public static void clean(int x, int y, int dir){

        arr[x][y] = -1;

        for(int i=0; i<4; i++){
            dir = (dir+3)%4;

            int nx = x+dx[dir];
            int ny = y+dy[dir];

            if(nx>=0 && ny>=0 && nx<N && ny<M){
                if(arr[nx][ny] == 0){
                    cnt++;
                    clean(nx, ny, dir);
                    return;
                }
            }
        }

        int d = (dir+2)% 4; // 반대방향으로 후진
        int bx = x+dx[d];
        int by = y+dy[d];
        if(bx>=0 && by>=0 && bx<N && by<M && arr[bx][by] != 1){
            clean(bx, by, dir); // 후진이지만 바라보는 방향은 유지
        }

    }

}
