package BJ.개인문제풀이.PGM;

public class 예상대진표_2_SSS {

    public int solution(int n, int a, int b){

        int ans = 0;

        while(true){
            a = a/2+a%2;
            b = b/2+b%2;
            ans++;
            if(a==b) break;
        }

        return ans;

    }

}
