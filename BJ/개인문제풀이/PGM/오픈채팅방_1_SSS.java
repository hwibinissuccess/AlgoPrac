package BJ.개인문제풀이.PGM;

import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방_1_SSS {

    public String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();
        int cnt = 0;

        for(int i=0; i<record.length; i++){

            String[] info = record[i].split(" ");

            if(info[0].equals("Leave")){
                continue;
            }else if(info[0].equals("Enter")){
                map.put(info[1], info[2]);
            } else{
                map.put(info[1], info[2]);
                cnt++;
            }
        }

        String[] ans = new String[record.length-cnt];
        int idx = 0;

        for(int i=0; i<record.length; i++){

            String[] info = record[i].split(" ");
            String nickname = map.get(info[1]);

            if(info[0].equals("Enter")){
                ans[idx++] = nickname+"님이 들어왔습니다.";
            } else if(info[0].equals("Leave")){
                ans[idx++] = nickname+"님이 나갔습니다.";
            }
        }

        return ans;
    }
}
