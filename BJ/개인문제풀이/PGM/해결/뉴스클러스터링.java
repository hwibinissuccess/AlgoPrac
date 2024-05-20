package BJ.개인문제풀이.PGM.해결;

import java.util.ArrayList;

public class 뉴스클러스터링 {

    public int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int ans = 0;
        ArrayList<String> zip1 = new ArrayList<>();
        ArrayList<String> zip2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> inter = new ArrayList<>();

        for(int i=0; i<str1.length()-1; i++){

            char first = str1.charAt(i);
            char second = str1.charAt(i+1);

            if(first>='a' && first <= 'z'
                    && second >= 'a' && second<='z'){
                zip1.add(first+""+second);
            }
        }

        for(int i=0; i<str2.length()-1; i++){

            char first = str2.charAt(i);
            char second = str2.charAt(i+1);

            if(first>='a' && first <= 'z'
                    && second >= 'a' && second<='z'){
                zip2.add(first+""+second);
            }
        }

        for(String s : zip1){

            if(zip2.remove(s)){
                inter.add(s);
            }

            union.add(s);
        }

        for(String s : zip2){
            union.add(s);
        }

        double jaka;

        if(union.size() == 0){
            jaka = 1;
        } else{
            jaka = (double)inter.size()/(double)union.size();
        }

        return (int)(jaka*65536);

    }

}
