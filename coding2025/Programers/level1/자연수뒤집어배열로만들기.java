package coding2025.Programers.level1;

public class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {

        String[] str = Long.toString(n).split("");

        int[] ans = new int[str.length];

        for(int i=0; i<str.length; i++){
            ans[i] = Integer.parseInt(str[str.length-1-i]);
        }

        return ans;

    }
}
