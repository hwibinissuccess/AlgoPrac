package BJ.개인문제풀이.PGM;

import java.util.Arrays;

public class 테이블해시함수_1 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {

        int ans = 0;

        Arrays.sort(data, (o1, o2) -> o1[col-1] != o2[col-1] ? o1[col-1]-o2[col-1]
                : o2[0]-o1[0]);

        for(int i=row_begin-1; i<=row_end-1; i++){

            int si = 0;
            for(int d : data[i]) si += (d%(i+1));
            ans = (ans^si);
        }

        return ans;
    }
}
