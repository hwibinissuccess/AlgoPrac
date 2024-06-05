package BJ.개인문제풀이.PGM.해결;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {

    public String solution(String s) {

        String ans = "";
        char[] sen = s.toCharArray();

        Arrays.sort(sen);

        for(int i=sen.length-1; i>=0; i--){
            ans += sen[i];
        }

        return ans;
    }
}
