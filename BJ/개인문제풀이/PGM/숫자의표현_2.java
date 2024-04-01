package BJ.개인문제풀이.PGM;

public class 숫자의표현_2 {

    public int solution(int n) {

        int ans = 0;

        for(int i=1; i<=n; i++){
            int sum = 0;
            for(int j=i; j<=n; j++){
                sum += j;

                if(sum == n){
                    ans ++;
                    break;
                } else if(sum > n){
                    break;
                }
            }
        }
        return ans;

    }

}
