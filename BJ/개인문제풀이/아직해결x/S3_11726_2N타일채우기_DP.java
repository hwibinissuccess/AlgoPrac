package BJ.개인문제풀이.아직해결x;

import java.util.Scanner;

public class S3_11726_2N타일채우기_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }
        System.out.println(dp[n]);
    }
}
