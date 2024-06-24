package BJ.개인문제풀이.PGM.해결;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {

    public int solution(int[] nums) {

        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int size =  map.size();
        int len = nums.length/2;

        if(size >= len) ans = len;
        else ans = size;

        return ans;
    }
}
