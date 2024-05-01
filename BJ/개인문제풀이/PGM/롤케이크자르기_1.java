package BJ.개인문제풀이.PGM;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크자르기_1 {

    public int solution(int[] topping) {

        int ans = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int e : topping){
            map2.put(e, map2.getOrDefault(e,0)+1);
        }

        for(int e : topping){
            map1.put(e,map1.getOrDefault(e,0)+1);

            if(map2.get(e)-1 == 0) map2.remove(e);
            else map2.put(e,map2.get(e)-1);


            if(map1.size() == map2.size()) ans++;

        }

        return ans;

    }

}
