package BJ.개인문제풀이.아직해결x;

import java.util.Scanner;

public class S3_1463_정수를1로만들기_DP {
    static int N;
    static int D[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        D= new int[N+1];
        D[1]=0;
        for(int i=2; i<=N; i++){
            D[i] = D[i-1]+1;
            if(i%2 == 0) D[i] = Math.min(D[i], D[i/2]+1);
            if(i%3 == 0) D[i] = Math.min(D[i],D[i/3]+1);
        }
        System.out.println(D[N]);
    }
}
