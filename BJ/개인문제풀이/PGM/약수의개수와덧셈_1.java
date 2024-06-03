package BJ.개인문제풀이.PGM;

public class 약수의개수와덧셈_1 {

    public int solution(int left, int right) {

        int ans = 0;

        for(int i=left; i<=right; i++){

            int cnt = 0;

            for(int j=1; j<=i; j++){
                if(i%j == 0) cnt++;
            }

            if(cnt%2 == 0) ans += i;
            else ans -= i;
        }

        return ans;
    }
}
