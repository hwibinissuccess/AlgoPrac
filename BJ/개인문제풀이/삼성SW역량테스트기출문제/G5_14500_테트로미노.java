package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_14500_테트로미노 {
    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int m;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit[i][j] = true;
                solve(i,j,arr[i][j],1);
                visit[i][j] = false;
            }
        }
        System.out.println(max);
    }

    static void solve(int row, int col, int sum, int count){

        // 테트로미노 완성 시 수들의 합 계산
        if(count==4){
            max = Math.max(max, sum);
            return;
        }

        // 상하좌우 탐색
        for(int i=0; i<4; i++){
            int nx = row+dx[i];
            int ny = col+dx[i];

            // 범위 벗어나면 예외 처리
            if(nx<0 || nx>=n || ny<0 || ny>=m){
                continue;
            }

            // 아직 방문하지 않았다면
            if(!visit[nx][ny]){

                // 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
                if(count==2){
                    visit[nx][ny] = true;
                    solve(row,col,sum+arr[nx][ny], count+1);
                    visit[nx][ny] = false;
                }

                visit[nx][ny] = true;
                solve(nx, ny, sum+arr[nx][ny],count+1);
                visit[nx][ny] = false;
            }


        }

    }

}
