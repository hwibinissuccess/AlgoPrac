package BJ.개인문제풀이.PGM.해결;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 보석쇼핑 {

    public int[] solution(String[] gems) {

        int kind = new HashSet<>(Arrays.asList(gems)).size();
        int[] ans = new int[2];
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int length = Integer.MAX_VALUE;

        for(int end=0; end<gems.length; end++){

            map.put(gems[end], map.getOrDefault(gems[end],0)+1);

            while(map.get(gems[start])>1){

                map.put(gems[start], map.get(gems[start])-1);
                start++;

            }

            if(kind == map.size() && length > end-start){
                length = end-start;
                ans[0] = start+1;
                ans[1] = end+1;
            }

        }

        return ans;

    }

}
