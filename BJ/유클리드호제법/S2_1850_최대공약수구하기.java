package BJ.유클리드호제법;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class S2_1850_최대공약수구하기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long a = sc.nextInt();
        long b = sc.nextInt();
        long result = gcd(a,b);
        while(result>0){
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
}
