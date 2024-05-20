package BJ.개인문제풀이.PGM;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축_3 {

    public ArrayList<Integer> solution(String msg) {

        int[] answer = {};

        ArrayList<Integer> ans = new ArrayList<>();
        int idx =1;
        HashMap<String, Integer> hs = new HashMap<>();

        for(char i='A'; i<='Z'; i++){
            hs.put(i+"", idx++);
        }

        int size = msg.length();

        for(int i=0; i<size; i++){

            int a = 1;

            while(i+a<=size && hs.containsKey(msg.substring(i, i+a))){
                a++;
            }

            if(i+a > size){
                ans.add(hs.get(msg.substring(i)));
                break;
            }

            ans.add(hs.get(msg.substring(i,i+a-1)));
            hs.put(msg.substring(i,i+a), idx++);
            if(a>1) i +=a-2;

        }

        return ans;

    }

}
