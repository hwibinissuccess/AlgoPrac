package BJ.개인문제풀이.PGM;

import java.util.Stack;

public class 짝지어제거하기_1_SSS {

    public int solution(String s){

        int ans = -1;
        char[] carr = s.toCharArray();
        Stack<Character> st = new Stack<>();

        for(int i=0 ;i<carr.length; i++){
            char c = carr[i];

            if(st.isEmpty()) st.push(c);
            else{

                if(st.peek() == c){
                    st.pop();
                } else{
                    st.push(c);
                }

            }

        }

        return st.isEmpty() ? 1 : 0;

    }

}
