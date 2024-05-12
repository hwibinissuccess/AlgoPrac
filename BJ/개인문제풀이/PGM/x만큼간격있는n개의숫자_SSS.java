package BJ.개인문제풀이.PGM;

public class x만큼간격있는n개의숫자_SSS {

    public long[] solution(int x, int n) {

        long[] ans = new long[n];

        long add = x;

        for(int i=0; i<ans.length; i++){
            ans[i] = add*(i+1);
        }

        return ans;

    }

}
