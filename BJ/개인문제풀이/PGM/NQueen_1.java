package BJ.개인문제풀이.PGM;

public class NQueen_1 {

    static int[] arr;
    static int N;
    static int cnt = 0;

    public int solution(int n) {

        N = n;
        arr = new int[n];

        nQueen(0);
        return cnt;
    }

    public static void nQueen(int depth){
        // 모든 원소를 다 채운 상태면 cnt 증가 및 return
        if(depth == N){
            cnt++;
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i;
            // 놓을 수 있는 위치일 경우 재귀
            if(Possibility(depth)){
                nQueen(depth+1);
            }
        }
    }

    public static boolean Possibility(int col){

        for(int i=0; i<col; i++){
            // 해당 열의 행과 i열의 행이 일치할경우(같은 행에 존재할 경우)
            if(arr[col] == arr[i]) return false;

                // 대각선상에 놓여있는 경우
                // = 열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우
            else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])){
                return false;
            }
        }

        return true;
    }
}
