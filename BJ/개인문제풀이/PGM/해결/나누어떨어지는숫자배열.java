package BJ.개인문제풀이.PGM.해결;

import java.util.ArrayList;
import java.util.Arrays;

public class 나누어떨어지는숫자배열 {

    public ArrayList<Integer> solution(int[] arr, int divisor) {

        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++){

            if(arr[i]%divisor == 0){
                ans.add(arr[i]);
            }
        }

        if(ans.size() == 0){
            ans.add(-1);
        }

        return ans;

    }

}
