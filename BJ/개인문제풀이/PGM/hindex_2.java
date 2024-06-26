package BJ.개인문제풀이.PGM;

import java.util.Arrays;

public class hindex_2 {

    public int solution(int[] citations) {

        int ans = 0;

        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++){
            int h = citations.length - i;

            if(citations[i] >= h){
                ans = h;
                break;
            }
        }

        return ans;
    }
}
