package BJ.개인문제풀이.PGM;

import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매_2_SSS {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){

        int[] ans = new int[enroll.length];

        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> memberIndexMap = new HashMap<>();

        for(int i=0; i<enroll.length; i++){
            parentMap.put(enroll[i], referral[i]);
            memberIndexMap.put(enroll[i],i);
        }

        for(int i=0; i<seller.length; i++){

            String now = seller[i];
            int profit = 100*amount[i];

            while(!now.equals("-")){
                int profitForParent = profit/10;
                int nowProfit = profit-profitForParent;

                ans[memberIndexMap.get(now)] += nowProfit;

                now = parentMap.get(now);
                profit /=10;

                if(profit<1){
                    break;
                }

            }

        }

        return ans;

    }

}
