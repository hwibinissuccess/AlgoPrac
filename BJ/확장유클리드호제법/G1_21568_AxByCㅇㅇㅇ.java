package BJ.확장유클리드호제법;

import java.io.*;
import java.util.StringTokenizer;

public class G1_21568_AxByCㅇㅇㅇ {
    public G1_21568_AxByCㅇㅇㅇ() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long gcd = gcd(a,b);
        if(c%gcd != 0){
            System.out.println(-1);
        }else {
            int mok = (int)(c/gcd);
            long[] ret = Excute(a,b);
            System.out.println(ret[0]*mok+" "+ret[1]*mok);
        }
    }

    private static long gcd(long a, long b) {
        while(b != 0){
            long temp = a%b;
            a=b;
            b=temp;
        }
        return Math.abs(a);
    }

    private static long[] Excute(int a, int b) {
        long[] ret = new long[2];
        if(b == 0){
            ret[0] = 1; ret[1] = 0; // x=1, y=0으로 설정하고 리턴
            return ret;
        }
        long q = a/b;
        long[] v = Excute(b, a%b); // 재귀 형태로 유클리드 호제법 수행
        ret[0] = v[1]; // 역순으로 올라오면서 x,y 값 계산하는 로직
        ret[1] = v[0] - v[1]*q;
        return ret;
    }
}
