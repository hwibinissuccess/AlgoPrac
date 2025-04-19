package coding2025.Programers.level1.Java;

public class 시저암호 {

    public String solution(String s, int n) {

        String ans = "";

        for(char ch : s.toCharArray()){
            if(ch==' '){
                ans += ch;
            } else if(ch >= 'a' && ch <='z'){
                ans += (char)('a'+(ch+n-'a')%26);
            } else if(ch>='A' && ch<='Z'){
                ans += (char)('A'+(ch+n-'A')%26);
            }
        }

        return ans;
    }
}
