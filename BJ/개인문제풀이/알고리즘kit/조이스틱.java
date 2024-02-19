package BJ.개인문제풀이.알고리즘kit;

public class 조이스틱 {

    public int solution(String name) {

        int ans = 0;
        int move = name.length()-1; // 오른쪽으로 간 횟수

        for(int i=0; i<name.length(); i++){
            ans =+ Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A'));
            if(i<name.length()-1 && name.charAt(i+1)=='A'){
                int endA = i+1;
                while(endA < name.length() && name.charAt(endA) == 'A')
                    endA++;

                move = Math.min(move, i*2+(name.length()-endA)); // 오른쪽으로 갔다가 다시 왼쪽으로 꺽기
                move = Math.min(move, i+(name.length()-endA)*2);
            }
        }

        return ans+move;

    }

}
