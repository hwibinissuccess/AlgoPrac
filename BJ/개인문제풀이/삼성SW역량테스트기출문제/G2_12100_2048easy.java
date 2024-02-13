package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_12100_2048easy {
    public static int n;
    static int max =0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int[][] temp;
    static int[] direct;
    static boolean[][] visit;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        direct = new int[5];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(5,0);
        System.out.println(max);
    }

    private static void DFS(int end, int index){
        if(index == end){
            confirm();
        } else{
            for(int i=0; i<4; i++){
                direct[index] = i;
                DFS(end, index+1);
            }
        }
    }

    private static void confirm(){

        temp = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            temp[i] = map[i].clone();
        }

        for(int d=0; d<direct.length; d++){
            visit = new boolean[n+1][n+1];

            if(direct[d] == 0){
                for(int i=1; i<=n; i++){
                    for(int j=1; j<=n; j++){
                        move(i,j,direct[d]);
                    }
                }
            } else if(direct[d] == 2){
                for(int i=n; i>=1; i--){
                    for(int j=1; j<=n; j++){
                        move(i,j,direct[d]);
                    }
                }
            } else if(direct[d] == 1){
                for(int i=n; i>=1; i--){
                    for(int j=1; j<=n; j++){
                        move(j,i,direct[d]);
                    }
                }
            } else {
                for(int i=1; i<=n; i++){
                    for(int j=1; j<=n; j++){
                        move(j,i,direct[d]);
                    }
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }
    }
    private static void move(int x, int y, int dir){

        if(temp[x][y] == 0){
            return;
        }

        while(true){
            int nx = x+dx[dir];
            int ny = y+dy[dir];

            if(nx<1 || ny <1 || nx>n || ny >n){
                return;
            }
            if(visit[nx][ny]){
                    return;
            }
            if(temp[nx][ny] == temp[x][y]){
                visit[nx][ny] = true;
                temp[nx][ny] *= 2;
                temp[x][y] = 0;
                return;
            } else if(temp[nx][ny] != 0){
                return;
            }

            temp[nx][ny] = temp[x][y];
            temp[x][y]=0;
            x = nx;
            y = ny;

        }
    }
}
