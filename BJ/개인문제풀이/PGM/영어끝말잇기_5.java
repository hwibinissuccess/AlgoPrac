package BJ.개인문제풀이.PGM;

import java.util.ArrayList;
import java.util.List;

public class 영어끝말잇기_5 {

    public int[] solution(int n, String[] words) {

        int[] ans = new int[2];
        List<String> list = new ArrayList<String>();
        boolean flag = true;

        for(int i=0; i<words.length; i++){
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) ||
                    list.contains(words[i])){
                ans[0] = (i%n)+1;
                ans[1] = (i/n)+1;
                flag = false;
                break;
            }

            list.add(words[i]);

        }

        if(flag) return new int[]{0,0};
        return ans;

    }

}
