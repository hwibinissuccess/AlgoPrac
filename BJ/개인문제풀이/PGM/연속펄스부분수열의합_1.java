package BJ.개인문제풀이.PGM;

public class 연속펄스부분수열의합_1 {

    public long solution(int[] sequence) {

        long ans = 0;
        boolean isPlus = true;

        long purse1 = 0;
        long purse2 = 0;

        for(int num : sequence){

            purse1 += isPlus ? num : -num;
            purse2 += isPlus ? -num : num;

            purse1 = Math.max(0,purse1);
            purse2 = Math.max(0,purse2);

            ans = Math.max(ans, Math.max(purse1, purse2));

            isPlus = !isPlus;

        }

        return ans;

    }

}
