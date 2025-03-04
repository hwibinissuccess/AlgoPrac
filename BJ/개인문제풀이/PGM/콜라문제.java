package BJ.개인문제풀이.PGM;

public class 콜라문제 {

    public int solution(int a, int b, int n) {

        int ans = 0;

        while(true){

            if(n<a) break;

            ans += (n/a)*b;

            n = ((n/a)*b)+(n%a);
        }

        return ans;

    }
}
