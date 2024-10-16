package BJ.개인문제풀이.PGM.해결;

public class 가장큰정사각형찾기_3 {

    public int solution(int [][]board){

        int[][] map = new int[board.length+1][board[0].length+1];
        int ans = 0;

        for(int i=1; i<=board.length; i++){
            for(int j=1; j<=board[0].length; j++){

                if(board[i-1][j-1] != 0){

                    int min = Math.min(Math.min(map[i-1][j], map[i][j-1]), map[i-1][j-1]);
                    map[i][j] = min+1;

                    ans = Math.max(ans, min+1);
                }
            }
        }

        return ans*ans;
    }
}
