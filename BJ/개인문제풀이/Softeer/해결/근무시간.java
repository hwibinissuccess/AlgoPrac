package BJ.개인문제풀이.Softeer.해결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 근무시간 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] time = new int[5]; // 요일별 일한시각 배열

        for(int i=0; i<5; i++){
            String[] t = br.readLine().split(" ");
            time[i] = getRealTime(t);
        }

        int sum = 0;
        for(int i=0; i<5; i++){
            sum += time[i];
        }

        System.out.println(sum);
    }

    public static int getRealTime(String[] arr){

        String[] start  = arr[0].split(":");
        String[] end = arr[1].split(":");

        int realS = (Integer.parseInt(start[0])*60)+(Integer.parseInt(start[1]));
        int realE = (Integer.parseInt(end[0])*60)+(Integer.parseInt(end[1]));

        return realE-realS;
    }
}
