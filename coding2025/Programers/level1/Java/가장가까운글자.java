package coding2025.Programers.level1.Java;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운글자 {

    public int[] solution(String s) {

        int[] ans = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
                ans[i] = -1;
            } else{
                ans[i] = i-map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }
        }

        return ans;
    }
}
