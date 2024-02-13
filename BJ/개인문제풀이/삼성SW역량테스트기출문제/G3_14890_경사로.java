package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.util.Scanner;

public class G3_14890_경사로 {
    static int n, l;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (calRow(i)) cnt++;
            if (calCol(i)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean calRow(int row) {
        boolean[] isIncline = new boolean[n]; // 경사면 설치 여부 확인 배열

        for (int i = 0; i < n - 1; i++) {
            int diff = board[row][i] - board[row][i+1];

            if(diff > 1 || diff<-1) return false;
            else if(diff == -1){
                for(int j=0; j<l; j++){
                    if(i-j<0 || isIncline[i-j]) return false;
                    if(board[row][i] != board[row][i-j]) return false;
                    isIncline[i-j] = true;
                }
            }
            else if(diff ==1){
                for(int j=1; j<=l; j++){
                    if(i+j >= n || isIncline[i+j]) return false;
                    if(board[row][i]-1 != board[row][i+j]) return false;
                    isIncline[i+j] = true;
                }
            }
        }
        return true;
    }

    public static boolean calCol(int col) {
        boolean[] isIncline = new boolean[n]; //경사면 설치 여부를 확인하는 배열

        for(int i = 0; i < n - 1; i++) {
            int diff = board[i][col] - board[i + 1][col];

            if(diff > 1 || diff < -1) return false; //높이차 1 초과하므로 false
            else if(diff == -1) { // 다음 계단이 한 계단 높다
                for(int j = 0; j < l; j++) { // 올라가는 경사로를 설치할 수 있는지 확인한다.
                    if(i - j < 0 || isIncline[i - j]) return false;
                    if(board[i][col] != board[i - j][col]) return false;
                    isIncline[i - j]  = true; //경사면 설치
                }
            }
            else if(diff == 1) { //다음 계단이 한 계단 낮다
                for(int j = 1; j <= l; j++) { //내려가는 경사로를 설치할 수 있는지 확인한다.
                    if(i + j >= n || isIncline[i + j]) return false;
                    if(board[i][col] - 1 != board[i + j][col]) return false;
                    isIncline[i + j] = true; //경사면 설치
                }
            }
        }
        return true;
    }

}
