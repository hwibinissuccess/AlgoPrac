package BJ.개인문제풀이.PGM.해결;

public class 연속펄스부분수열의합 {

    public long solution(int[] sequence) {

        long ans = 0;
        boolean flag = true;
        long purse1 = 0;
        long purse2 = 0;

        for(int i=0; i<sequence.length; i++){

            purse1 += flag ? sequence[i] : -sequence[i];
            purse2 += flag ? -sequence[i] : sequence[i];

            if(purse1 <= 0) purse1 = 0;
            if(purse2 <= 0) purse2 = 0;

            ans = Math.max(ans, Math.max(purse1, purse2));

            flag = !flag;

        }

        return ans;


    }

}
