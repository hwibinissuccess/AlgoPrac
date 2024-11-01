package BJ.개인문제풀이.BJ;

import java.util.*;
import java.io.*;


public class OX퀴즈 {


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc<t; tc++){
            String quiz = br.readLine();
            Stack<Integer> st = new Stack<>();
            int ans = 0;

            for(int i=0; i<quiz.length(); i++){
                if(quiz.charAt(i) == 'X'){
                    while(!st.isEmpty()){
                            ans += st.pop();
                        }

                } else{
                    if(st.isEmpty()){
                        st.push(1);
                    } else{
                        st.push((st.peek()+1));
                    }
                }
            }

            while(!st.isEmpty()){
                ans += st.pop();
            }
            System.out.println(ans);
        }

    }
}
