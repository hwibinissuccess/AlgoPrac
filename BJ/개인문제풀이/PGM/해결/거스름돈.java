package BJ.개인문제풀이.PGM.해결;

import java.util.Arrays;

public class 거스름돈 {

    public int solution(int n, int[] money) {

        int ans = 0;
        Arrays.sort(money);
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i=0; i<money.length; i++){
            for(int j=money[i]; j<=n; j++){
                dp[j] += dp[j-money[i]]%1000000007;
            }
        }

        return dp[n];

    }

}
