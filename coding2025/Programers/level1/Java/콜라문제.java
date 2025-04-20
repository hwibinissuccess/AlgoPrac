package coding2025.Programers.level1.Java;

public class 콜라문제 {

    public int solution(int a, int b, int n) {

        int ans = 0;

        while(n>=a){
            ans += (n/a)*b;
            n=(n/a)*b+(n%a);
        }

        return ans;
    }
}
