package BJ.개인문제풀이.PGM;

public class 카운트다운_6_SSS {
    int[][] dp;

    public int[] solution(int target) {

        int[] ans = new int[2];

        dp = new int[target+1][2];

        for(int i=0; i<=target; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = 0;
        }

        dp[0][0] = 0;

        for(int i=1; i<=target; i++){
            for(int j=1; j<=20; j++){

                int b_or_s = -1;

                if(i-50>=0){
                    if(dp[i][0]>dp[i-50][0]+1){
                        dp[i][0] = dp[i-50][0]+1;
                        dp[i][1] = dp[i-50][1]+1;
                    } else if(dp[i][0] == dp[i-50][0]+1){
                        dp[i][1] = Math.max(dp[i][1], dp[i-50][1]+1);
                    }
                }

                if(i-j>=0){
                    if(dp[i][0] > dp[i-j][0]+1){
                        dp[i][0] = dp[i-j][0]+1;
                        dp[i][1] = dp[i-j][1]+1;
                    } else if(dp[i][0] == dp[i-j][0]+1){
                        dp[i][1] = Math.max(dp[i][1], dp[i-j][1]+1);
                    }
                }

                if(i-2*j>=0){
                    if(dp[i][0] > dp[i-2*j][0]+1){
                        dp[i][0] = dp[i-2*j][0]+1;
                        dp[i][1] = dp[i-2*j][1];
                    }
                }

                if(i-3*j>=0){
                    if(dp[i][0] > dp[i-3*j][0]+1){
                        dp[i][0] = dp[i-3*j][0]+1;
                        dp[i][1] = dp[i-3*j][1];
                    }
                }

            }
        }

        ans[0] = dp[target][0];
        ans[1] = dp[target][1];

        return ans;

    }

}
