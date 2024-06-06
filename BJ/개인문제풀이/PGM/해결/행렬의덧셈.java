package BJ.개인문제풀이.PGM.해결;

public class 행렬의덧셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] ans = new int[arr1.length][arr1[0].length];
        int len = arr1.length;
        int len2 = arr1[0].length;

        for(int i=0; i<len; i++){
            for(int j=0; j<len2; j++){
                ans[i][j] = arr1[i][j]+arr2[i][j];
            }
        }

        return ans;
    }
}
