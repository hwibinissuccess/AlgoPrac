package BJ.개인문제풀이.PGM;

public class 크기가작은부분문자열_2 {

    public int solution(String t, String p) {

        int cnt = 0;
        int len = p.length();
        long target = Long.parseLong(p);

        for(int i=0; i<t.length()-len+1; i++){
            StringBuilder num = new StringBuilder();
            for(int j=i; j<i+len; j++){
                num.append(t.charAt(j));
            }

            long nums = Long.parseLong(num.toString());

            if(target >= nums) cnt++;
        }

        return cnt;
    }
}
