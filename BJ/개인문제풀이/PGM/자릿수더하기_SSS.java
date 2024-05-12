package BJ.개인문제풀이.PGM;

public class 자릿수더하기_SSS {

    public int solution(int n) {

        int ans = 0;
        String s = String.valueOf(n);

        for(int i=0; i<s.length(); i++){

            String num = String.valueOf(s.charAt(i));

            ans += Integer.parseInt(num);

        }

        return ans;

    }

}
