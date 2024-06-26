package BJ.개인문제풀이.PGM.해결;

public class 피보나치수 {

    public int solution(int n) {


        int ans = 0;
        int[] pibo = new int[n+1];

        pibo[0] = 0;
        pibo[1] = 1;

        for(int i=2; i<=n; i++){
            pibo[i] = (pibo[i-1]+pibo[i-2])%1234567;
        }

        return pibo[n]%1234567;

    }

}
