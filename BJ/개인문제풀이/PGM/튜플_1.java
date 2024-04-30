package BJ.개인문제풀이.PGM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 튜플_1 {

    public ArrayList<Integer> solution(String s) {

        ArrayList<Integer> ans = new ArrayList<>();

        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2).replace("},{","-");

        String str[] = s.split("-");

        Arrays.sort(str, new Comparator<String>(){
            public int compare(String s1, String s2){
                return Integer.compare(s1.length(), s2.length());
            }
        });

        for(String x : str){
            String[] temp = x.split(",");
            for(int i=0; i<temp.length; i++){
                int n = Integer.parseInt(temp[i]);
                if(!ans.contains(n)) ans.add(n);
            }
        }

        return ans;

    }

}
