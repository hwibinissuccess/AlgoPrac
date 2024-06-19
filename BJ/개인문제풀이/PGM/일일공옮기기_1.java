package BJ.개인문제풀이.PGM;

import java.util.Stack;

public class 일일공옮기기_1 {

    public String[] solution(String[] s) {

        String[] ans = new String[s.length];
        StringBuilder sb;

        for(int i=0; i<s.length; i++){

            Stack<Character> st = new Stack<>();
            String str = s[i];
            int cnt = 0;

            for(int j=0; j<str.length(); j++){

                char z = str.charAt(j);

                if(st.size()>=2){
                    char y = st.pop();
                    char x = st.pop();

                    if(x == '1' && y=='1' && z=='0'){
                        cnt++;
                    } else{
                        st.push(x);
                        st.push(y);
                        st.push(z);
                    }
                } else{
                    st.push(z);
                }
            }

            int idx = st.size();
            boolean flag = false;
            sb = new StringBuilder();

            while(!st.isEmpty()){
                if(!flag && st.peek()=='1'){
                    idx--;
                }

                if(!flag && st.peek() == '0'){
                    flag = true;
                }

                sb.insert(0,st.pop());
            }

            if(cnt > 0){
                while(cnt > 0){
                    sb.insert(idx, "110");
                    idx += 3;
                    cnt--;
                }

                ans[i] = sb.toString();
            } else{
                ans[i] = s[i];
            }
        }

        return ans;
    }
}
