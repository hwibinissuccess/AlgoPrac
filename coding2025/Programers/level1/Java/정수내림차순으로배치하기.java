package coding2025.Programers.level1.Java;

import java.util.Arrays;
import java.util.Collections;

public class 정수내림차순으로배치하기 {
    public long solution(long n) {

        long ans = 0;

        String[] str = Long.toString(n).split("");
        Arrays.sort(str, Collections.reverseOrder());

        String s = "";

        for(String ss : str){
            s += ss;
        }

        ans = Long.parseLong(s);

        return ans;
    }
}
