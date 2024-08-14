package BJ.개인문제풀이.PGM;

public class 점찍기_1 {


    public long solution(int k, int d) {

        long ans = 0;

        for(long i=0; i<=d; i+=k){
            long maxY = (long)Math.sqrt(d*d-i*i);
            ans += (maxY/k) +1;
        }

        return ans;
    }
}
