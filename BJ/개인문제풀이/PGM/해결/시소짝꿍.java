package BJ.개인문제풀이.PGM.해결;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍 {

    public long solution(int[] weights) {

        long ans = 0;
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);

        for(int weight : weights){

            double a = weight*1.0;
            double b = (weight*2.0)/3.0;
            double c = (weight*1.0)/2.0;
            double d = (weight*3.0)/4.0;

            if(map.containsKey(a)) ans += map.get(a);
            if(map.containsKey(b)) ans += map.get(b);
            if(map.containsKey(c)) ans += map.get(c);
            if(map.containsKey(d)) ans += map.get(d);

            map.put((weight*1.0), map.getOrDefault(weight*1.0, 0)+1);
        }

        return ans;
    }
}
