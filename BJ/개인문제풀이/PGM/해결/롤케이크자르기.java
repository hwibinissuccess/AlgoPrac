package BJ.개인문제풀이.PGM.해결;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크자르기 {

    public int solution(int[] topping) {

        int ans = 0;
        Map<Integer, Integer> map1 = new HashMap<>();

        for(int i=0; i<topping.length; i++){
            map1.put(topping[i], map1.getOrDefault(topping[i],0)+1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();

        for(int i=0; i<topping.length; i++){

            map2.put(topping[i], map2.getOrDefault(topping[i],0)+1);


            map1.put(topping[i], map1.get(topping[i])-1);
            if(map1.get(topping[i]) == 0) map1.remove(topping[i]);


            if(map1.size() == map2.size()){
                ans++;
            }

        }

        return ans;

    }

}
