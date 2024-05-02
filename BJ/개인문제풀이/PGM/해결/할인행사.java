package BJ.개인문제풀이.PGM.해결;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {

        int ans = 0;
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }

        int day = 10;

        for(int i=0; i<discount.length-day+1; i++){

            Map<String, Integer> map2 = new HashMap<>();

            for(int j=i; j<i+day; j++){
                map2.put(discount[j], map2.getOrDefault(discount[j],0)+1);
            }

            boolean flag = true;

            for(String key : map.keySet()){
                if(map.get(key) != map2.get(key)){
                    flag = false;
                    break;
                }
            }

            if(flag) ans += 1;

        }

        return ans;

    }

}
