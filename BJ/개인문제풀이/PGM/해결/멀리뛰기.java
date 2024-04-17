package BJ.개인문제풀이.PGM.해결;

public class 멀리뛰기 {

    public long solution(int n) {

        long ans = 0;
        long[] dp = new long[2001];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%1234567;
        }

        return dp[n];

    }

}
