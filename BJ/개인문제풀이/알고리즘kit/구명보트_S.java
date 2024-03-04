package BJ.개인문제풀이.알고리즘kit;

import java.util.Arrays;

public class 구명보트_S {

    public int solution(int[] people, int limit) {

        int ans = 0;
        Arrays.sort(people);
        int index=0;

        for(int i=people.length-1; i>=index; i--){
            if(people[i] + people[index] <= limit){
                index++;
                ans++;
            } else{
                ans++;
            }
        }
        return ans;

    }

}
