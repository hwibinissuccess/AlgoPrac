package BJ.개인문제풀이.BJ;

import java.io.*;
import java.util.*;

public class 소수찾기 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;

        for(int i=0; i<t; i++){

            int num = Integer.parseInt(st.nextToken());

            if(isPrime(num)) ans++;
        }

        System.out.println(ans);

    }

    public static boolean isPrime(int num){
        if(num < 2) return false;

        for(int i=2; i<=(int)Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }

        return true;
    }
}
