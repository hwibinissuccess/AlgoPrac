package BJ.개인문제풀이.알고리즘kit;

import java.util.Arrays;

public class 징검다리 {
    public int solution(int dis, int[] rocks, int n) {

        Arrays.sort(rocks);

        int left = 0;
        int right = dis;
        int res = Integer.MIN_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }

                if (cnt > n) {
                    break;
                }
            }

            if (dis - prev < mid && cnt <= n) {
                cnt++;
            }

            if (cnt > n) {
                right = mid - 1;
            } else {
                left = mid + 1;

                res = mid;
            }

        }
        return res;

    }

}
