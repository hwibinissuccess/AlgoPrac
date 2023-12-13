package BJ.오일러피;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G1_11689_오일러피함수구현하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;

        for(long p=2; p<=Math.sqrt(n); p++){ // 제곱근까지만 진행
            if(n%p == 0){ // p가 소인수인지 확인
                result = result - result/p; // 결과값 업데이터
                while(n%p == 0){
                    n /= p;
                }
            }
        }
        if(n>1) // 아직 소인수 구성이 남아 있을 떄
            // 반복문에서 제곱근까지만 탐색했으니, 1개의 소인수가 누락되는 케이스
            result = result - result/n;
        System.out.println(result);
    }
}
