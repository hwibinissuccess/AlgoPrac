package BJ.개인문제풀이.PGM.해결;

public class 숫자의표현 {

    public int solution(int n) {

        int ans = 0;

        for(int i=1; i<=n; i++){
            int sum = 0;

            for(int j=i; j<=n; j++){
                sum += j;
                if(sum == n){
                    ans ++;
                } else if(sum > n){
                    break;
                }
            }
        }
        return ans;

    }

}
