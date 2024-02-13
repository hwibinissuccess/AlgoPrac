package BJ.개인문제풀이.삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_14891_톱니바퀴 {
    static int[][] gear = new int[4][8];
    static int d[];
    static int n,m;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; i++){
            String line = br.readLine();
            for(int j=0; j<8; j++){
                gear[i][j] = line.charAt(j)-'0';
            }
        }

        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());

        while(k-->0){
            st = new StringTokenizer(br.readLine());
            // 배열에 담긴 gear는 1부터 시작이 아닌, 0부터 이므로 -1
            int gearN = Integer.parseInt(st.nextToken())-1;
            int turn = Integer.parseInt(st.nextToken());

            // 톱니의 회전방향 정보 담기
            d = new int[4];

            d[gearN] = turn;
            checkDir(gearN);
            gearTurn();

        }

        int ans =0;
        if(gear[0][0] == 1) ans += 1;
        if(gear[1][0] == 1) ans += 2;
        if(gear[2][0] == 1) ans += 4;
        if(gear[3][0] == 1) ans += 8;
        System.out.println(ans);

    }

    static void checkDir(int gearN){
        // 좌측 톱니 회전 방향 검사
        for(int i=gearN-1; i>=0; i--){
            if(gear[i][2] != gear[i+1][6]){
                d[i] = -d[i+1];
            } else{
                break;
            }
        }
        // 우측 방향 검사
        for(int i=gearN+1; i<4; i++){
            if(gear[i][6] != gear[i-1][2]){
                d[i] = -d[i-1];
            }else{
                break;
            }
        }
    }

    static void gearTurn(){
        int temp=0;

        for(int i=0; i<4; i++){
            // 시계방향 회전
            if(d[i] == 1){
                temp = gear[i][7];
                for(int j=7; j>0; j--){
                    gear[i][j] = gear[i][j-1];
                }
                gear[i][0] = temp;
            }
            if(d[i] == -1){
                temp = gear[i][0];
                for(int j=0; j<7; j++){
                    gear[i][j] = gear[i][j+1];
                    gear[i][7] = temp;
                }
            }
        }
    }

}
