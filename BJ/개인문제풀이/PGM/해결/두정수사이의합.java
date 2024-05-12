package BJ.개인문제풀이.PGM.해결;

public class 두정수사이의합 {

    public long solution(int a, int b) {

        long ans = 0;
        long aa = (long)Math.max(a,b);
        long bb = (long)Math.min(a,b);

        for(long i=bb; i<=aa; i++){

            ans += i;

        }

        return ans;

    }

}
