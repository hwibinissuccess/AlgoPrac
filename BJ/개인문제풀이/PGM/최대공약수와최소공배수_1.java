package BJ.개인문제풀이.PGM;

public class 최대공약수와최소공배수_1 {

    public int[] solution(int n, int m) {

        int[] ans = new int[2];

        int min = Math.min(n,m);
        int max = Math.max(n,m);

        while(min != 0){
            int r = max%min;
            max = min;
            min = r;
        }

        return new int[] {max, n*m/max};
    }
}
