package coding2025.Programers.level1.Java;

public class 기사단원의무기 {
    public int solution(int number, int limit, int power) {

        int ans = 0;

        for(int i=1; i<=number; i++){
            int cnt = 0;

            for(int j=1; j*j<=i; j++){
                if(j*j==i) cnt++;
                else if(i%j==0) cnt+=2;
            }

            if(cnt>limit) cnt = power;
            ans+= cnt;
        }

        return ans;
    }
}
