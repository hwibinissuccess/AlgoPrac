package BJ.개인문제풀이.PGM;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍_2 {

    public long solution(int[] weights) {

        long ans = 0;
        Map<Double, Integer> map = new HashMap<>();

        Arrays.sort(weights);

        for(int i : weights){

            double a = i*1.0;
            double b = (i*2.0)/3.0;
            double c = (i*1.0)/2.0;
            double d = (i*3.0)/4.0;

            if(map.containsKey(a)) ans += map.get(a);
            if(map.containsKey(b)) ans += map.get(b);
            if(map.containsKey(c)) ans += map.get(c);
            if(map.containsKey(d)) ans += map.get(d);

            map.put((i*1.0), map.getOrDefault((i*1.0),0)+1);

        }

        return ans;
    }
}
