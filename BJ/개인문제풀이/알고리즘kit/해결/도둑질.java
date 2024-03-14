package BJ.개인문제풀이.알고리즘kit.해결;

public class 도둑질 {

    public int solution(int[] money) {

        int ans = 0;

        if(money.length == 3){
            for(int i=0; i<3; i++){
                if(ans < money[i]){
                    ans = money[i];
                }
            }
            return ans;
        }

        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];

        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);

        dp2[0] = 0;
        dp2[1] = money[1];

        for(int i=2; i<money.length; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i]);
            ans = Math.max(ans, dp2[i]);

            if(i == money.length-1) break;

            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+money[i]);
            ans = Math.max(ans, dp1[i]);

        }
        return ans;



    }


}
