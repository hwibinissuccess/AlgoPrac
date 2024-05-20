package BJ.개인문제풀이.PGM.해결;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {

    public long solution(long n) {

        String nn = String.valueOf(n);
        String[] str = new String[nn.length()];

        for(int i=0; i<nn.length(); i++){
            str[i] = String.valueOf(nn.charAt(i));
        }

        Arrays.sort(str, (o1, o2) -> Integer.parseInt(o2)-Integer.parseInt(o1));

        String ans = "";

        for(int i=0; i<str.length; i++){
            ans += str[i];
        }

        return Long.parseLong(ans);


    }

}
