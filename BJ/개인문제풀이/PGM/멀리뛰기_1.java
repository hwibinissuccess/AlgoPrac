package BJ.개인문제풀이.PGM;

public class 멀리뛰기_1 {

    public long solution(int n) {

        long[] ans = new long[2001];
        ans[1] = 1;
        ans[2] = 2;

        for(int i=3; i<2001; i++){
            ans[i] = (ans[i-1]+ans[i-2])%1234567;


        }

        return ans[n];

    }

}
