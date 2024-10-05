package BJ.개인문제풀이.PGM.해결;

import java.util.Stack;

public class 괄호회전하기_SSS {

    public int solution(String s) {

        int ans = 0;
        int len = s.length();

        for(int i=0; i<len; i++){

            String str = s.substring(i,len)+s.substring(0,i);
            Stack<Character> st = new Stack<>();

            for(int j=0; j<len; j++){

                char c = str.charAt(j);

                if(st.isEmpty()){
                    st.push(c);
                } else if(c == ')' && st.peek() == '('){
                    st.pop();
                } else if(c == '}' && st.peek() == '{'){
                    st.pop();
                } else if(c == ']' && st.peek() == '['){
                    st.pop();
                } else{
                    st.push(c);
                }

            }

            if(st.isEmpty()) ans++;

        }

        return ans;

    }

}
