package BJ.개인문제풀이.알고리즘kit;

import java.util.ArrayList;
import java.util.List;

public class 모음사전_S {

    static char[] words = {'A','E','I','O','U'};
    static int max = 5;

    public int solution(String word) {

        int ans = 0;

        List<String> elements = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            DFS(elements, String.valueOf(words[i]));
        }

        for(int i=0; i<elements.size(); i++){

            if(elements.get(i).equals(word)){
                ans = i+1;
                break;
            }
        }
        return ans;

    }

    public static void DFS(List<String> elements, String str){
        if(str.length() > max) return;

        if(!elements.contains(str)) elements.add(str);

        for(int i=0; i<words.length; i++){
            DFS(elements, str+words[i]);
        }
    }


}
