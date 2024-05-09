package BJ.개인문제풀이.PGM;

public class 타일링2xn_1 {

    public int solution(int n) {

        int ans = 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){

            dp[i] = (dp[i-1]+dp[i-2])%1000000007;

        }

        return dp[n];



    }

}
