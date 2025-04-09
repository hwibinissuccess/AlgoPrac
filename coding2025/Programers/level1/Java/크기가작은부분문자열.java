package coding2025.Programers.level1.Java;

public class 크기가작은부분문자열 {
    public int solution(String t, String p) {

        int len = p.length();
        long num = Long.parseLong(p);
        int ans = 0;

        for(int i=0; i<t.length()-len+1; i++){
            long diff = Long.parseLong(t.substring(i, i+len));
            if(diff<=num) ans++;
        }
        return ans;
    }
}
