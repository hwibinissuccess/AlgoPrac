package BJ.개인문제풀이.알고리즘kit;

public class 카펫 {

    public int[] solution(int brown, int yellow) {

        int[] ans = new int[2];
        int sum = brown + yellow;

        for (int i = 3; i < sum; i++) {
            int j = sum / i;

            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);

                if (center == yellow) {
                    ans[0] = col;
                    ans[1] = row;
                    return ans;
                }

            }

        }
        return ans;
    }

}
