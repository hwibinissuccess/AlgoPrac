package BJ.개인문제풀이.PGM.해결;

public class 이진변환반복하기 {

    public int[] solution(String s) {

        int[] ans = new int[2]; // 정답 배열

        while(s.length() > 1){
            int cnt = 0; // 1을 셀 변수
            String temp = ""; // 임시 변수

            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1') temp += "1"; // 1이면 카운트 늘리기
                if(s.charAt(i) == '0') ans[1]++;
            }

            s = temp; // 문자열을 임시변수 저장해둔 것으로 다시 정의
            int leng = s.length(); // s 길이 저장 변수

            s = Integer.toBinaryString(leng); // 길이를 이진 변환
            ans[0]++;




        }

        return ans;

    }

}
