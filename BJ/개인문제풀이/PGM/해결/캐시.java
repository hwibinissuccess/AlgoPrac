package BJ.개인문제풀이.PGM.해결;

import java.util.ArrayList;
import java.util.List;

public class 캐시 {

    public int solution(int cacheSize, String[] cities) {

        int ans = 0;

        if(cacheSize == 0) return cities.length*5;

        //Queue<String> q = new LinkedList<>();
        List<String> list = new ArrayList<>();

        for(int i=0; i<cities.length; i++){

            String city = cities[i].toUpperCase();

            if(list.contains(city)){
                list.remove(city);
                list.add(city);
                ans += 1;
            } else{
                list.add(city);
                ans+=5;
            }

            if(cacheSize < list.size()){
                list.remove(0);
            }

        }

        return ans;
    }

}
