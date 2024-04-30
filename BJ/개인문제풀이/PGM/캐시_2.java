package BJ.개인문제풀이.PGM;

import java.util.ArrayList;

public class 캐시_2 {

    public int solution(int cacheSize, String[] cities) {

        int ans = 0;
        ArrayList<String> cache = new ArrayList<>();

        if(cacheSize == 0){
            return cities.length*5;
        }

        for(int i=0; i<cities.length; i++){
            String city = cities[i].toUpperCase();

            if(cache.contains(city)){
                cache.remove(city);
                cache.add(city);
                ans+=1;
            } else{

                if(cache.size() == cacheSize){
                    cache.remove(0);
                }

                cache.add(city);
                ans+=5;

            }
        }

        return ans;

    }

}
