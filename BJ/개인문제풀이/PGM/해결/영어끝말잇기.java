package BJ.개인문제풀이.PGM.해결;

import java.util.ArrayList;
import java.util.List;

public class 영어끝말잇기 {

    public int[] solution(int n, String[] words) {

        int[] ans = new int[2];
        List<String> list = new ArrayList<>();

        for(int i=0; i<words.length; i++){

            if(i>0 && words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1) ||
                    list.contains(words[i])){

                ans[0] = (i%n)+1;
                ans[1] = (i/n)+1;
                break;

            }

            list.add(words[i]);

        }

        return ans;

    }

}
