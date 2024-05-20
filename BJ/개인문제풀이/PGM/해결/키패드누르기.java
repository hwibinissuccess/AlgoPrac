package BJ.개인문제풀이.PGM.해결;

public class 키패드누르기 {

    public String solution(int[] numbers, String hand) {

        String ans = "";
        int left = 10;
        int right = 12;

        for(int i=0; i<numbers.length; i++){

            int num = numbers[i];

            if(num == 1 || num == 4 || num == 7){
                left = num;
                ans += "L";
            }

            if(num == 3 || num == 6 || num == 9){
                right = num;
                ans += "R";
            }

            if(num == 2 || num == 5 || num == 8 || num == 0){

                if(num == 0){
                    num = 11;
                }

                int leftDiff = Math.abs((num-left)/3)+Math.abs((num-left)%3);
                int rightDiff = Math.abs((num-right)/3)+Math.abs((num-right)%3);

                if(leftDiff < rightDiff){
                    left = num;
                    ans += "L";
                } else if(rightDiff < leftDiff){
                    right = num;
                    ans += "R";
                } else{
                    if(hand.equals("right")){
                        right = num;
                        ans += "R";
                    } else{
                        left = num;
                        ans += "L";
                    }
                }
            }
        }

        return ans;
    }

}
