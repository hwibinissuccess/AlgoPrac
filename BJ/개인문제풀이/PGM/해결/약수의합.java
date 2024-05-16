package BJ.개인문제풀이.PGM.해결;

public class 약수의합 {

    public int solution(int n) {

        int ans = 0;

        for(int i=1; i<=n; i++){
            if(n%i == 0){
                ans += i;
            }
        }

        return ans;

    }

}
