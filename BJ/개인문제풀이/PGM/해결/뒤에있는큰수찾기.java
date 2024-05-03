package BJ.개인문제풀이.PGM.해결;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에있는큰수찾기 {

    public int[] solution(int[] numbers) {

        int[] ans = new int[numbers.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);

        for(int i=0; i<numbers.length; i++){

            while(!st.isEmpty() && numbers[i] > numbers[st.peek()]){

                ans[st.pop()] = numbers[i];

            }

            st.push(i);

        }

        return ans;

    }

}
