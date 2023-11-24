import java.util.Scanner;

public class G2_1300_배열에서k번째수찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 1, end = K;
        long ans = 0;

        //이진 탐색
        while(start <= end){
            long middle = (start+end)/2;
            long cnt = 0;
            //중앙값보다 작은 수는 몇 개인지
            for(int i=1; i<=N; i++){
                cnt += Math.min(middle/i,N); //작은 수를 카운트하는 핵심 로직
            }
            if(cnt<K){
                start = middle +1;
            }else{
                ans=middle;
                end=middle-1;
            }
        }
        System.out.println(ans);
    }

}
