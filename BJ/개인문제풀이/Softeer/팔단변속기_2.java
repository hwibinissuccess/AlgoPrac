package BJ.개인문제풀이.Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 팔단변속기_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] asc = {1,2,3,4,5,6,7,8};
        int[] dec = {8,7,6,5,4,3,2,1};
        String[] input = br.readLine().split(" ");
        int[] num = new int[8];

        for(int i=0; i<8; i++){
            num[i] = Integer.parseInt(input[i]);
        }

        if(Arrays.equals(asc,num)) System.out.println("ascending");
        else if(Arrays.equals(dec, num)) System.out.println("descending");
        else System.out.println("mixed");
        br.close();

    }
}
