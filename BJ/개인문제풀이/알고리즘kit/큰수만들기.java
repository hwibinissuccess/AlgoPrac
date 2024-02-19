package BJ.개인문제풀이.알고리즘kit;

public class 큰수만들기 {

    public String solution(String number, int k) {

        String ans = "";
        StringBuilder sb = new StringBuilder();

        char[] array = number.toCharArray();

        int len = array.length -k;

        int start = 0;

        for(int i=0; i<len; i++){
            char max = '0';
            for(int j=start; j<=i+k; j++){
                if(array[j]>max){
                    max = array[j];
                    start = j+1;
                }
            }
            sb.append(Character.toString(max));
        }

        ans = sb.toString();
        return ans;

    }

}
