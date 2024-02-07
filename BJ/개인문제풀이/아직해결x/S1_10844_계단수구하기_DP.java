package BJ.개인문제풀이.아직해결x;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_10844_계단수구하기_DP {
    static Long[][] dp;
    static int N;
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new Long[N+1][10];

        for(int i=0; i<10; i++){
            dp[1][i] = 1L;
        }
        long result=  0;

        for(int i=1; i<=9; i++){
            result += recure(N,i);
        }
        System.out.println(result % MOD);
    }

    static long recure(int d, int v){
        if(d == 1){
            return dp[d][v];
        }
        if(v==0){
            dp[d][v] = recure(d-1,1);
        } else if (v==9) {
            dp[d][v] = recure(d-1,8);
        }
        else{
            dp[d][v] = recure(d-1,v-1)+recure(d-1,v+1);
        }
        return dp[d][v]%MOD;
    }

}
