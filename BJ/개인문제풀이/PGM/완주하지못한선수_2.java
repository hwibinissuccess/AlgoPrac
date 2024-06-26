package BJ.개인문제풀이.PGM;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수_2 {

    public String solution(String[] participant, String[] completion) {

        String ans = "";
        Map<String, Integer> map = new HashMap<>();

        for (String s : participant) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }

        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                ans = s;
                break;
            }
        }

        return ans;
    }
}
