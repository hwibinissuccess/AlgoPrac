package BJ.개인문제풀이.PGM;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열의의개수_2 {

    public int solution(int[] elements) {

        int length = elements.length;
        int[] ele2 = new int[length*2];
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<length; i++){
            ele2[i] = ele2[i+length] = elements[i];
        }

        for(int s=1; s<=length; s++){
            for(int i=0; i<length; i++){
                int sum = 0;
                for(int j=i; j<s+i; j++){
                    sum += ele2[j];
                }
                set.add(sum);
            }
        }

        return set.size();

    }

}
