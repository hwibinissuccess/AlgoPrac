package BJ.개인문제풀이.PGM.해결;

import java.util.Arrays;

public class hindex_2 {

    public int solution(int[] citations) {

        int ans = citations.length;
        Arrays.sort(citations);

        for(int num : citations){

            if(num >= ans){
                break;
            }

            ans--;
        }

        return ans;
    }
}
