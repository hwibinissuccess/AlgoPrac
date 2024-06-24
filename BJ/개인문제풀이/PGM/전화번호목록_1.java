package BJ.개인문제풀이.PGM;

import java.util.HashSet;
import java.util.Set;

public class 전화번호목록_1 {

    public boolean solution(String[] phone_book) {

        boolean ans = true;
        Set<String> set = new HashSet<>();

        for(String phone : phone_book){
            set.add(phone);
        }

        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                if(set.contains(phone_book[i].substring(0,j)))
                    return false;
            }
        }

        return true;

    }
}
