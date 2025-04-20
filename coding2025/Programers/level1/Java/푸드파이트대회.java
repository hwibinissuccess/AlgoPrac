package coding2025.Programers.level1.Java;

public class 푸드파이트대회 {

    public String solution(int[] food) {

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<food.length; i++){

            int cnt = food[i]/2;
            sb.append(String.valueOf(i).repeat(cnt));
        }

        String ans = sb+"0";
        ans += sb.reverse();

        return ans;
    }
}
