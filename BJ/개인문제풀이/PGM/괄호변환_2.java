package BJ.개인문제풀이.PGM;

public class 괄호변환_2 {

    public String solution(String p) {

        if(p.isEmpty()) return p;

        int left = 0;
        int right = 0;
        int index = 0;

        for(int i=0; i<p.length(); i++){

            if(p.charAt(i) == '('){
                left++;
            } else{
                right++;
            }

            if(left == right){
                index = i;
                break;
            }
        }

        String u = p.substring(0,index+1);
        String v = p.substring(index+1);

        if(isCorrect(u)) return u + solution(v);

        return "(" + solution(v) + ")" + reverse(u);
    }

    public static boolean isCorrect(String u){

        int left = 0;
        int right = 0;

        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) == '('){
                left++;
            } else{
                right++;
            }

            if(right > left) return false;
        }

        return true;
    }

    public static String reverse(String u){

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<u.length()-1; i++){

            if(u.charAt(i) == '('){
                sb.append(')');
            } else{
                sb.append('(');
            }
        }

        return sb.toString();
    }
}
