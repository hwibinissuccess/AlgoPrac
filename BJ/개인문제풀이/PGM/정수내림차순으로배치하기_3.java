package BJ.개인문제풀이.PGM;

import java.util.Arrays;

public class 정수내림차순으로배치하기_3 {

    public long solution(long n) {

        String str = String.valueOf(n);

        long ans = 0;

        String[] temp = new String[str.length()];

        for(int i=0; i<str.length(); i++){

            temp[i] = String.valueOf(str.charAt(i));

        }

        Arrays.sort(temp, (o1, o2) -> Integer.parseInt(o2)-Integer.parseInt(o1));


        String ans2 = "";

        for(int i=0; i<str.length(); i++){

            ans2 += temp[i];

        }

        return Long.parseLong(ans2);

    }

}
