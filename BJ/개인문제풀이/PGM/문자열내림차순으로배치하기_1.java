package BJ.개인문제풀이.PGM;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내림차순으로배치하기_1 {

    public String solution(String s) {

        String ans = "";
        String[] temp = s.split("");

        Arrays.sort(temp, Collections.reverseOrder());

        for(int i=0; i<temp.length; i++){
            ans += temp[i];
        }

        return ans;
    }
}
