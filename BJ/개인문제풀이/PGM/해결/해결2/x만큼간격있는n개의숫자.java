package BJ.개인문제풀이.PGM.해결.해결2;

public class x만큼간격있는n개의숫자 {
    public long[] solution(int x, int n) {

        long[] ans = new long[n];
        long xx = (long)x;
        long nn = (long)n;
        ans[0] = xx;

        for(int i=1; i<n; i++){

            ans[i] = ans[i-1]+xx;
        }

        return ans;
    }
}
