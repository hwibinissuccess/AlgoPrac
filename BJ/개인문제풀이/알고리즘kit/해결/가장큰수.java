package BJ.개인문제풀이.알고리즘kit.해결;

import java.util.Arrays;

public class 가장큰수 {

    public String solution(int[] numbers) {

        String[] temp = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            temp[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(temp, (o1,o2) -> (o2+o1).compareTo(o1+o2));

        StringBuilder sb = new StringBuilder();

        if(temp[0].equals("0")){
            return "0";
        }

        for(int i=0; i<temp.length; i++){
            sb.append(temp[i]);
        }

        return sb.toString();

    }

}
