package BJ.개인문제풀이.PGM.해결;

public class 정수제곱근판별 {

    public long solution(long n) {

        long ans = 0;


        double x = Math.sqrt(n);

        if(x%1 == 0){
            ans = (long)Math.pow(x+1,2);
        } else{
            ans = -1;
        }

        return ans;
    }

}
