package coding2025.Programers.level1.Java;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내림차순으로배치하기 {

    public String solution(String s) {

        String ans = "";

        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());

        for(String a : str)
            ans += a;

        return ans;
    }
}
