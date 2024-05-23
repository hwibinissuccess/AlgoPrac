package BJ.개인문제풀이.PGM.해결;

public class 연속된부분수열의합 {

    public int[] solution(int[] sequence, int k) {

        int[] ans = new int[2];
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while(right < sequence.length){

            sum += sequence[right];

            while(sum > k){

                sum -= sequence[left];
                left++;
            }

            if(sum == k && right-left < minLength){

                minLength = right-left;
                ans[0] = left;
                ans[1] = right;
            }

            right++;
        }

        return ans;
    }
}
