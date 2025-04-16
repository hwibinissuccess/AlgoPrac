package coding2025.Programers.level1.Java;

public class 이상한문자만들기 {

    public String solution(String s) {

        String ans = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array){
            cnt = ss.contains(" ") ? 0 : cnt+1;
            ans += cnt%2==0 ? ss.toLowerCase() : ss.toUpperCase();
        }

        return ans;
    }
}
