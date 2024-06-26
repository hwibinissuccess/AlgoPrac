package BJ.개인문제풀이.PGM;

public class 보행자천국_4_SSS {

    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {

        int ans = 0;
        int[][][] dp = new int[2][m+1][n+1];

        dp[0][0][0] = 1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(cityMap[i][j] == 0){
                    dp[0][i+1][j] += (dp[0][i][j]+dp[1][i][j])%MOD;
                    dp[1][i][j+1] += (dp[0][i][j]+dp[1][i][j])%MOD;

                } else if(cityMap[i][j] == 2){

                    dp[0][i+1][j] += dp[0][i][j];
                    dp[0][i+1][j] %= MOD;

                    dp[1][i][j+1] += dp[1][i][j];
                    dp[1][i][j+1] %= MOD;
                }
            }
        }

        return (dp[0][m-1][n-1] + dp[1][m-1][n-1])%MOD;
    }
}
