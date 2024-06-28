package BJ.개인문제풀이.Softeer.해결;
import java.io.*;
import java.util.*;

public class 지도자동구축 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int line = 2;
        int add = 1;

        for(int i=0; i<N; i++){
            if(i == 0){
                line += add;
                continue;
            }
            add *= 2;
            line += add;
        }

        int ans = line*line;

        System.out.println(ans);
    }
}
