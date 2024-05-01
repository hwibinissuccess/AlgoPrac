package BJ.개인문제풀이.PGM;

public class 행렬의곱셈_3_SSS {

    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] ans = new int[arr1.length][arr2[0].length];

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2[0].length; j++){
                for(int k=0; k<arr1[0].length; k++){
                    ans[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }

        return ans;

    }

}
