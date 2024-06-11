package BJ.개인문제풀이.PGM.해결;

public class 삼각달팽이 {

    public int[] solution(int n) {

        int[][] map = new int[n+1][n+1];
        int[] ans = new int[(n*(n+1))/2];
        int x = -1;
        int y = 0;
        int idx = 1;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){

                if(i%3 == 0) x++;
                else if(i%3 == 1) y++;
                else if(i%3 == 2){
                    x--;
                    y--;
                }

                map[x][y] = idx++;
            }
        }

        int in = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(map[i][j] == 0) break;

                ans[in++] = map[i][j];
            }
        }

        return ans;
    }
}
