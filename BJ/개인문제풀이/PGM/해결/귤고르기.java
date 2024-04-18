package BJ.개인문제풀이.PGM.해결;

import java.util.*;

public class 귤고르기 {

    public int solution(int k, int[] tangerine) {

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }

        List<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList, Collections.reverseOrder());

        int sum=0;

        for(int v : valueList){
            if(sum+v >= k){
                ans++;
                break;
            } else{
                sum+=v;
                ans++;
            }
        }

        return ans;



    }

}
