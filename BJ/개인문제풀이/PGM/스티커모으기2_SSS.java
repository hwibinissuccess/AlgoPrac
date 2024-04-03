package BJ.개인문제풀이.PGM;

public class 스티커모으기2_SSS {

    public long solution(int sticker[]) {

        long ans = 0;

        if(sticker.length == 1) return sticker[0];

        long[] dp1 = new long[sticker.length];
        long[] dp2 = new long[sticker.length];

        dp1[0] = sticker[0];
        dp1[1] = dp1[0];

        dp2[0] = 0;
        dp2[1] = sticker[1];



        for(int i=2; i<sticker.length; i++){
            dp2[i] = Math.max(sticker[i]+dp2[i-2], dp2[i-1]);


            if(i == sticker.length-1) break;

            dp1[i] = Math.max(sticker[i]+dp1[i-2], dp1[i-1]);


        }

        return Math.max(dp1[sticker.length-2], dp2[sticker.length-1]);

    }

}
