package BJ.개인문제풀이.PGM;

public class 정수제곱근판별_4_SSS {

    public long solution(long n) {

        long ans = 0;

        double x = Math.sqrt(n);

        if(x%1 == 0){
            ans = (long)Math.pow(x+1, 2);
        } else return -1;

        return ans;




    }

}
