package BJ.개인문제풀이.PGM.해결;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {

    public ArrayList<String> solution(String[] record) {

        int changeCnt = 0;
        Map<String, String> idNick = new HashMap<>();

        for(int i=0; i<record.length; i++){

            String[] temp = record[i].split(" ");

            if(temp[0].equals("Enter")){
                idNick.put(temp[1], temp[2]);
            } else if(temp[0].equals("Change")){
                idNick.put(temp[1], temp[2]);
                changeCnt++;
            }
        }

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0; i<record.length; i++){

            String[] temp = record[i].split(" ");

            if(temp[0].equals("Enter")){
                ans.add(idNick.get(temp[1])+"님이 들어왔습니다.");
            } else if(temp[0].equals("Leave")){
                ans.add(idNick.get(temp[1])+"님이 나갔습니다.");
            }
        }

        return ans;
    }
}
