package BJ.개인문제풀이.PGM;

public class 행렬테두리회전하기_1 {

    static int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {

        map = new int[rows][columns];
        int[] ans = new int[queries.length];
        int num = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                map[i][j] = num++;
            }
        }

        for(int i=0; i<queries.length; i++){
            ans[i] = rotate(queries[i]);
        }

        return ans;
    }

    public static int rotate(int[] query){

        int r1 = query[0]-1;
        int c1 = query[1]-1;
        int r2 = query[2]-1;
        int c2 = query[3]-1;

        int temp = map[r1][c1];
        int min = temp;

        for(int i=r1; i<r2; i++){
            map[i][c1] = map[i+1][c1];
            if(min > map[i][c1]) min = map[i][c1];
        }

        for(int i=c1; i<c2; i++){
            map[r2][i] = map[r2][i+1];
            if(min > map[r2][i]) min = map[r2][i];
        }

        for(int i=r2; i>r1; i--){
            map[i][c2] = map[i-1][c2];
            if(min > map[i][c2]) min = map[i][c2];
        }

        for(int i=c2; i>c1; i--){
            map[r1][i] = map[r1][i-1];
            if(min > map[r1][i]) min = map[r1][i];
        }
        map[r1][c1+1] = temp;

        return min;
    }
}
