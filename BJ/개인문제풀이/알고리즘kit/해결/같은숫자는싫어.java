package BJ.개인문제풀이.알고리즘kit.해결;

import java.util.Stack;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {

        Stack<Integer> st = new Stack<>();


        for(int i=1; i<arr.length; i++){
            if(st.isEmpty()) st.push(arr[0]);

            if(arr[i-1] == arr[i]){
                continue;
            }else if(arr[i-1] != arr[i]){
                st.push(arr[i]);
            }
        }
        int[] ans = new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            ans[i] = st.pop();
        }

        return ans;

    }

}
