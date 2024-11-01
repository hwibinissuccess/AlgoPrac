package BJ.개인문제풀이.BJ;

import java.io.*;
import java.util.*;

public class 팩토리얼 {

    public static void main(String args[]) throws IOException{

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int ans = 1;

        for(int i=1; i<=num; i++){
            ans *=i;
        }

        System.out.println(ans);
    }
}
