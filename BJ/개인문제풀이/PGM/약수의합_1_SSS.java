package BJ.개인문제풀이.PGM;

public class 약수의합_1_SSS {

    public int solution(int n) {

        int ans = 0;

        for(int i=1; i<=n; i++){

            if(n%i == 0) ans += i;

        }

        return ans;

    }

}
