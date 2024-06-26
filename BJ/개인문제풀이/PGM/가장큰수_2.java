package BJ.개인문제풀이.PGM;

import java.util.Arrays;

public class 가장큰수_2 {

    public String solution(int[] numbers) {

        String[] arr = new String[numbers.length];

        for(int i=0; i<arr.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        if(arr[0].equals("0")){
            return "0";
        }

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<arr.length; i++){
            ans.append(arr[i]);
        }

        return ans.toString();
    }
}
