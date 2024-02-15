package BJ.개인문제풀이.알고리즘kit;

import java.util.Stack;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {

        int[] ans;

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(i==0) st.push(arr[i]);

            else if(st.peek() != arr[i]) st.push(arr[i]);

        }

        ans = new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            ans[i] = st.pop();
        }

        return ans;


    }

}
