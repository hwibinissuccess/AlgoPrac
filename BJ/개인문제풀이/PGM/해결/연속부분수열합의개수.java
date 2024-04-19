package BJ.개인문제풀이.PGM.해결;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {

    public int solution(int[] elements) {

        int[] ele2 = new int[elements.length*2];
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<elements.length; i++){
            ele2[i] = ele2[i+elements.length] = elements[i];
        }

        for(int s=1; s<=elements.length; s++){
            for(int i=0; i<elements.length; i++){
                int sum =0;
                for(int j=i; j<s+i; j++){
                    sum += ele2[j];
                }
                set.add(sum);
            }
        }

        return set.size();

    }

}
