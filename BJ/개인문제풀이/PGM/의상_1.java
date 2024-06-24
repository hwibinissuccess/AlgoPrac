package BJ.개인문제풀이.PGM;

import java.util.HashMap;
import java.util.Map;

public class 의상_1 {

    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();
        int ans = 1;

        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }

        for(String key : map.keySet()){
            ans *= (map.get(key)+1);
        }

        ans -= 1;

        return ans;
    }
}
