package BJ.개인문제풀이.PGM.해결;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 압축 {

    public ArrayList<Integer> solution(String msg) {

        ArrayList<Integer> ans = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        int idx = 1;

        for(char i='A'; i<='Z'; i++){
            dic.put(i+"", idx++);
        }

        int len = msg.length();

        for(int i=0; i<len; i++){

            int a = 1;

            while(i+a <= len && dic.containsKey(msg.substring(i, i+a))){
                a++;
            }

            if(i+a > len){
                ans.add(dic.get(msg.substring(i, i+a-1)));
                break;
            }

            ans.add(dic.get(msg.substring(i,i+a-1)));
            dic.put(msg.substring(i,i+a), idx++);
            if(a>1) i += a-2;
        }

        return ans;

    }
}
