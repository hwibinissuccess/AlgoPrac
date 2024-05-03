package BJ.개인문제풀이.PGM;

import java.util.Stack;

public class 택배상자_1 {

    public int solution(int[] order) {

        int ans = 0;
        int[] pri = new int[order.length];

        for(int i=0; i<order.length; i++){
            pri[order[i]-1] = i;
        }

        Stack<Integer> st = new Stack<>();

        int target = 0;

        for(int i=0; i<pri.length; i++){

            if(pri[i] == target){
                target++;
            } else{
                st.push(pri[i]);
            }

            while(!st.isEmpty() && st.peek() == target){
                st.pop();
                target++;
            }

        }

        return target;

    }

}
