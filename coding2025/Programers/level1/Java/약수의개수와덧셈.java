package coding2025.Programers.level1.Java;

public class 약수의개수와덧셈 {


        public int solution(int left, int right) {

        int ans = 0;

        for(int i=left; i<=right; i++){
            int cnt = 1;

            for(int j=1; j<=i/2; j++){
                if(i%j==0) cnt++;
            }

            if(cnt%2==0) ans += i;
            else ans -= i;
        }

        return ans;
    }
}
