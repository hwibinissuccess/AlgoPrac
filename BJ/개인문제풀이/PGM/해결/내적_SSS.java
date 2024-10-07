package BJ.개인문제풀이.PGM.해결;

public class 내적_SSS {

    public int solution(int[] a, int[] b) {

        int ans = 0;

        for(int i=0; i<a.length; i++){

            ans += a[i]*b[i];
        }

        return ans;
    }
}
