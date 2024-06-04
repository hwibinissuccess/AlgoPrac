package BJ.개인문제풀이.PGM.해결;

import java.util.Stack;

public class 표편집 {

    public String solution(int n, int k, String[] cmd) {

        int size = n;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<cmd.length; i++){

            String[] temp = cmd[i].split(" ");

            if(temp[0].equals("U")){
                k -= Integer.parseInt(temp[1]);
            } else if(temp[0].equals("D")){
                k += Integer.parseInt(temp[1]);
            } else if(temp[0].equals("C")){
                st.push(k);
                size--;
                if(k == size) k--;
            } else if(temp[0].equals("Z")){
                if(st.pop() <= k) k++;
                size++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<size; i++){
            sb.append("O");
        }

        while(!st.isEmpty()){
            sb.insert(st.pop(), "X");
        }

        return sb.toString();
    }
}
