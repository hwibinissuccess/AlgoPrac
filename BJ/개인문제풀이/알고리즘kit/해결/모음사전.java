package BJ.개인문제풀이.알고리즘kit.해결;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {


    static char[] words = {'A','E','I','O','U'};
    static int max = 5;

    public int solution(String word) {

        int ans = 0;
        List<String> temp = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            DFS(temp, String.valueOf(words[i]));
        }

        for(int i=0; i<temp.size(); i++){
            if(temp.get(i).equals(word)){
                ans = i+1;
            }
        }

        return ans;

    }

    public static void DFS(List<String> temp, String str){

        if(str.length() > max){
            return;
        }

        if(!temp.contains(str)) temp.add(str);

        for(int i=0; i<words.length; i++){
            DFS(temp, str+words[i]);
        }

    }


}
