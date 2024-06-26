package BJ.개인문제풀이.PGM;

public class 삼각달팽이_4_SSS {

    public int[] solution(int n) {

        int[] ans = new int[(n*(n+1))/2];
        int[][] map = new int[n][n];

        int x = -1, y= 0;
        int num =1;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){

                if(i%3 == 0) x++;
                else if(i%3 == 1) y++;
                else if(i%3 == 2){
                    x--;
                    y--;
                }
                map[x][y] = num++;
            }
        }

        int k=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 0){
                    break;
                }
                ans[k++] = map[i][j];
            }
        }

        return ans;
    }
}
