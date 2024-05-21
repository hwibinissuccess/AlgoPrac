package BJ.개인문제풀이.PGM;

import java.util.ArrayList;

public class 연속된부분수열의합_1 {

    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int left = 0, right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int[] ans = new int[]{-1, -1};

        while (right < n) {
            sum += sequence[right];

            while (sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    ans[0] = left;
                    ans[1] = right;
                }
            }

            right++;
        }

        return ans;
    }

}
