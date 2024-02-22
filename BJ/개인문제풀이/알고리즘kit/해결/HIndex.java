package BJ.개인문제풀이.알고리즘kit.해결;

import java.util.Arrays;

public class HIndex {

    public int solution(int[] citations) {

        int ans = 0;
        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++){
            int h = citations.length-i;

            if(citations[i] >= h){
                ans = h;
                break;
            }
        }
        return ans;

    }

}
