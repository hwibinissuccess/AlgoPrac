package BJ.개인문제풀이.PGM.해결;

public class N개의최소공배수 {

    public int solution(int[] arr) {

        int ans = arr[0];

        for(int i=1; i<arr.length; i++){
            ans = lcm(ans, arr[i]);
        }

        return ans;

    }

    public static int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }else{
            return gcd(b,a%b);
        }
    }

    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

}
