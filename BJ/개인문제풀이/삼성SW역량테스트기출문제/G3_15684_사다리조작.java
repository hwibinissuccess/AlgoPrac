package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_15684_사다리조작 {
    static int n,m,h,ans;
    static int[][] map;
    static boolean finish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h+1][n+1];

        int x,y;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[x][y+1] = 2;
        }

        for(int i=0; i<=3; i++){
            ans=i;
            DFS(1,0);
            if(finish) break;
        }
        System.out.println((finish) ? ans : -1);
    }

    public static void DFS(int x, int cnt){
        if(finish) return;
        if(ans == cnt){
            if(check()) finish = true;
            return;
        }

        for(int i=x; i<h+1; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    DFS(i, cnt + 1);
                    map[i][j] = map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean check(){
        for(int i=1; i<=n; i++){
            int x=1, y=i;
            for(int j=0; j<h; j++){
                if(map[x][y] == 1) y++;
                else if(map[x][y] == 2) y--;
                x++;
            }
            if(y != i) return false;
        }
        return true;
    }

}
