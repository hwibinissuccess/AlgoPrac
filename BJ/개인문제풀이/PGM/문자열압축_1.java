package BJ.개인문제풀이.PGM;

public class 문자열압축_1 {


    public int solution(String s) {

        int ans = s.length();
        int cnt = 1;

        for(int i=1; i<=s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0,i);

            for(int j=i; j<=s.length(); j+=i){
                int endIdx = Math.min(j+i, s.length());
                String compare = s.substring(j,endIdx);

                if(base.equals(compare)){
                    cnt++;
                } else{
                    if(cnt >= 2){
                        sb.append(cnt);
                    }
                    sb.append(base);
                    base=compare;
                    cnt = 1;
                }
            }
            sb.append(base);
            ans = Math.min(ans, sb.length());
        }
        return ans;
    }
}
