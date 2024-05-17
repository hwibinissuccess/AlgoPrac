package BJ.개인문제풀이.PGM.해결;

public class 없는숫자더하기 {

    public int solution(int[] numbers) {

        int[] num = new int[10];
        num[0] = 1;

        for(int i=0; i<numbers.length; i++){
            num[numbers[i]] = 1;
        }

        int ans = 0;

        for(int i=1; i<num.length; i++){
            if(num[i] == 0){
                ans += i;
            }
        }

        return ans;

    }

}
