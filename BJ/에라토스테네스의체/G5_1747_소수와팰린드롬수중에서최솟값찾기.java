package BJ.에라토스테네스의체;

import java.util.Scanner;

public class G5_1747_소수와팰린드롬수중에서최솟값찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[1000001]; // N 범위까지 소수 구하기
        for(int i=2; i<A.length;i++){
            A[i]=i;
        }
        for(int i=2; i<Math.sqrt(A.length); i++){ // 제곱근까지만 수행
            if(A[i] == 0){
                continue;
            }
            for(int j=i+i; j<A.length; j=j+i){ // 배수 지우기
                A[j] = 0;
            }
        }
        int i=N;
        while(true){ // N부터 1씩 증가시키면ㅅ더 소수와 펠린드롬 수가 맞는지 확인하기
            if(A[i] != 0){
                int result = A[i];
                if(isPalindrome(result)){
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int target){ // 팰린드롬 판별 함수
        char temp[] = String.valueOf(target).toCharArray();
        int s=0;
        int e=temp.length-1;
        while(s<e){
            if(temp[s] != temp[e])
                return false;
            s++;
            e--;
        }
        return true;
    }

}
