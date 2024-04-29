package BJ.개인문제풀이.PGM;

import java.util.HashMap;
import java.util.Map;

public class 할인행사_3 {

    public int solution(String[] want, int[] number, String[] discount) {

        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        int day = 10;

        for(int i=0; i<want.length; i++){
            map.put(want[i],number[i]);
        }

        for(int i=0; i<discount.length-day+1; i++){

            Map<String,Integer> map2 = new HashMap<>();

            for(int j=0; j<day; j++){
                map2.put(discount[i+j], map2.getOrDefault(discount[i+j],0)+1);
            }

            Boolean flag = true;

            for(String key : map.keySet()){
                if(map.get(key) != map2.get(key)){
                    flag = false;
                    break;
                }
            }

            ans += flag ? 1 : 0;

        }

        return ans;

    }

}
