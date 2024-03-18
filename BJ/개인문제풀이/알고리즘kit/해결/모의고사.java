package BJ.개인문제풀이.알고리즘kit.해결;

import java.util.ArrayList;

public class 모의고사 {


    int max = 0;
    int a1,a2,a3 = 0;

    public ArrayList solution(int[] answers) {

        ArrayList<Integer> ans = new ArrayList<>();

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        for(int i=0; i<answers.length; i++){


            if(answers[i] == one[i%5]) a1++;
            if(answers[i] == two[i%8]) a2++;
            if(answers[i] == three[i%10]) a3++;

            max = Math.max(a1, Math.max(a2,a3));

        }

        if(max == a1) ans.add(1);
        if(max == a2) ans.add(2);
        if(max == a3) ans.add(3);

        return ans;

    }


}
