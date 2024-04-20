package BJ.개인문제풀이.PGM.해결;

import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        int[] ans = new int[enroll.length];
        Map<String,String> parentMap = new HashMap<>();
        Map<String,Integer> indexMap = new HashMap<>();

        for(int i=0; i<enroll.length; i++){
            parentMap.put(enroll[i], referral[i]);
            indexMap.put(enroll[i],i);
        }

        for(int i=0; i<seller.length; i++){

            String now = seller[i];
            int money = amount[i]*100;

            while(!now.equals("-")){

                int parentMoney = money/10;
                int myMoney = money-parentMoney;

                ans[indexMap.get(now)] += myMoney;

                now = parentMap.get(now);
                money = parentMoney;

            }

        }

        return ans;

    }

}
