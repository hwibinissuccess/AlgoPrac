package BJ.개인문제풀이.알고리즘kit.해결;

public class 부족한금액계산하기 {

    public long solution(int price, int money, int count) {

        long ans = 0;
        long sum = 0;


        for(int i=1; i<=count; i++){
            sum += price*i;

            if(i == count){
                if(money - sum >= 0){
                    ans = 0;
                }else if(money - sum < 0) {
                    ans = sum - money;
                }
            }


        }
        return ans;

    }

}
