package BJ.개인문제풀이.알고리즘kit.해결;

import java.util.Arrays;

public class 구명보트 {

    public int solution(int[] people, int limit) {

        Arrays.sort(people);
        int index = 0;
        int ans = 0;

        for(int i=people.length-1; i>=0; i--){


            if(i<index) break;
            if(i==index){
                ans++;
                break;
            }

            if(people[i]+people[index] <= limit){
                ans++;
                index++;
            } else if(people[i]+people[index] > limit){
                ans++;
            }
        }

        return ans;
    }

}
