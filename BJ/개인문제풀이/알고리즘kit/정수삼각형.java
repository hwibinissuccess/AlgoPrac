package BJ.개인문제풀이.알고리즘kit;

public class 정수삼각형 {

    public int solution(int[][] triangle) {

        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i=1; i<triangle.length; i++){

            // 왼쪽
            dp[i][0] = dp[i-1][0] + triangle[i][0];

            // 중간
            for(int j=1; j<=i; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])+triangle[i][j];
            }

            // 오른쪽
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }

        int ans = 0;

        for(int i=0; i<triangle.length; i++){
            ans = Math.max(ans, dp[triangle.length-1][i]);
        }

        return ans;

    }

}
