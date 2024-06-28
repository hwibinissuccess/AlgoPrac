package BJ.개인문제풀이.Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 징검다리_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int[] dol = new int[in.length];
        for(int i=0; i<in.length; i++){
            dol[i] = Integer.parseInt(in[i]);
        }

        int ans = 1;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i=1;i <dol.length; i++){
            int stan = dol[i];
            for(int j=0; j<i; j++){
                if(stan > dol[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        for(int i=0; i<dp.length; i++){
            ans = Math.max(dp[i],ans);
        }
        System.out.println(ans);
    }
}
