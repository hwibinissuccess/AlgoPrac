package BJ.개인문제풀이.PGM.해결;

import java.util.Stack;

public class 짝지어제거하기 {

    public int solution(String s){

        int ans = 0;
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i<s.length(); i++){

            if(st.isEmpty()){
                st.push(s.charAt(i));
                continue;
            }

            if(st.peek() == s.charAt(i)){
                st.pop();
            } else{
                st.push(s.charAt(i));
            }
        }

        if(st.isEmpty()){
            ans = 1;
            return ans;
        } else{
            ans = 0;
            return ans;
        }

    }

}
