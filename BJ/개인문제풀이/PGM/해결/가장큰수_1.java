package BJ.개인문제풀이.PGM.해결;

import java.util.Arrays;

public class 가장큰수_1 {

    public String solution(int[] numbers) {

        StringBuilder sb = new StringBuilder();
        String[] number = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            number[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(number, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        if(number[0].equals("0")) return "0";

        for(String num : number){
            sb.append(num);
        }

        return sb.toString();
    }
}
