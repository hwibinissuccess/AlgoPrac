package BJ.개인문제풀이.PGM.해결;

public class 등굣길_2 {

    public int solution(int m, int n, int[][] puddles) {

        int mod = 1000000007;
        int[][] dp = new int[n+1][m+1];
        for(int[] puddle : puddles){

            int x = puddle[1];
            int y = puddle[0];

            dp[x][y] = -1;
        }
        dp[1][1] = 1%mod;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(dp[i][j] < 0) continue;
                if(dp[i-1][j] > 0) dp[i][j] += dp[i-1][j]%mod;
                if(dp[i][j-1] > 0) dp[i][j] += dp[i][j-1]%mod;
            }
        }

        return dp[n][m]%mod;
    }
}
