package BJ.개인문제풀이.알고리즘kit;

import java.util.Stack;

public class 주식가격 {

    public int[] solution(int[] prices) {

        int[] ans = new int[prices.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<prices.length; i++){
            while(!st.isEmpty() && prices[i]<prices[st.peek()]){
                ans[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ans[st.peek()] = prices.length - st.peek()-1;
            st.pop()게;
        }
        return ans;
    }

}
