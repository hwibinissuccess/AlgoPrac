package coding2025.Programers.level1.Java;

public class 최대공약수와최소공배수 {

    public int[] solution(int n, int m) {

        int[] ans = new int[2];
        int a = Math.max(n,m);
        int b = Math.min(n,m);

        ans[0] = gcd(a,b);
        ans[1] = gce(a,b);

        return ans;
    }

    public int gcd(int a, int b){

        while(b!=0){
            int t = a%b;
            a=b;
            b=t;
        }

        return a;
    }

    public int gce(int a, int b){
        int c = gcd(a,b);
        return a*b/c;
    }
}
