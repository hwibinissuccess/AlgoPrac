package BJ.개인문제풀이.PGM;

public class 두원사이의정수쌍_1 {


    public long solution(int r1, int r2) {

        long ans = 0;

        for(int i=1; i<=r2; i++){

            long min = (int)Math.ceil(Math.sqrt(1.0*r1*r1-1.0*i*i));
            long max = (int)Math.floor(Math.sqrt(1.0*r2*r2-1.0*i*i));

            ans += (max-min+1);
        }

        return ans*4;

    }
}
