package coding2025.Programers.level1.Java;

public class 정수제곱근판별 {

    public long solution(long n) {

        long ans = 0;

        double sqrt = Math.sqrt(n);

        if(sqrt%1 == 0)
            ans = (long)Math.pow(sqrt+1,2);
        else ans = -1;

        return ans;
    }
}
