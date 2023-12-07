package BJ.그리디;

import java.util.Scanner;

public class S2_1541_최솟값을만드는괄호배치찾기 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");
        for(int i=0; i<str.length; i++){
            int temp = mySum(str[i]);
            if(i==0)
                ans = ans+temp; // 가장 앞에 있는 값만 더하기
            else
                ans = ans-temp; // 뒷 부분은 더한 값 빼주기
        }
        System.out.println(ans);
    }
    static int mySum(String a){ // 나뉜 그룹의 더하기 연산 수행 함수
        int sum=0;
        String temp[]=a.split("[+]");
        for(int i=0; i<temp.length; i++){
            sum += Integer.parseInt(temp[i]);
        }
        return sum;

    }
}
