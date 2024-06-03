package BJ.개인문제풀이.PGM;

public class 쿼드압축후개수세기_2 {

    static int[] ans;

    public int[] solution(int[][] arr) {

        ans = new int[2];
        quad(arr, 0,0, arr.length);
        return ans;
    }

    public static void quad(int[][] arr, int x, int y, int size){

        if(zip(arr, x, y, size, arr[x][y])){

            if(arr[x][y] == 1)
                ans[1]++;
            else ans[0]++;
            return;
        }

        quad(arr, x, y, size/2);
        quad(arr,x,y+size/2, size/2);
        quad(arr,x+size/2, y,size/2);
        quad(arr,x+size/2,y+size/2, size/2);
    }

    public static boolean zip(int[][] arr, int x, int y, int size, int val){

        for(int i=x; i<x+size; i++)
            for(int j=y; j<y+size; j++)
                if(arr[i][j] != val)
                    return false;
        return true;
    }
}
