package BJ.개인문제풀이.PGM;

public class 삼xn타일링_1 {


    public long solution(int n) {

        long ans = 0;
        long mod = 1000000007;
        long[] tile = new long[5001];

        tile[0] = 1;
        tile[2] = 3;

        for(int i=4; i<=n; i+=2){

            tile[i] = (tile[i-2]*4%mod - tile[i-4]%mod + mod)%mod;
        }

        return tile[n];

    }
}
