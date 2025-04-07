package coding2025.Programers.level1.Java;

import java.util.Stack;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {

        Stack<Integer> st = new Stack<>();

        for(int i : arr){
            if(st.empty() || st.peek()!=i){
                st.push(i);
            }
        }

        return st.stream().mapToInt(i->i).toArray();
    }
}
