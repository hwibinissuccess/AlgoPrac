package BJ.개인문제풀이.PGM;

import java.util.Stack;

public class 표편집_5 {


    public String solution(int n, int k, String[] cmd) {

        Stack<Integer> remove_order = new Stack<>();
        int table_size = n;

        for(int i=0; i<cmd.length; i++){

            char c = cmd[i].charAt(0);

            if(c == 'D')
                k += Integer.parseInt(cmd[i].substring(2));
            else if(c == 'U')
                k -= Integer.parseInt(cmd[i].substring(2));
            else if(c == 'C'){
                remove_order.add(k);
                table_size--;

                if(k == table_size) k--;
            }
            else if(c == 'Z'){
                if(remove_order.pop() <= k) k++;
                table_size++;
            }
        }

        StringBuilder builder = new StringBuilder();

        for(int i=0; i<table_size; i++)
            builder.append("O");

        while(!remove_order.isEmpty())
            builder.insert(remove_order.pop().intValue(), "X");
        String ans = builder.toString();
        return ans;

    }
}
