package BJ.개인문제풀이.PGM;

import java.util.Arrays;
import java.util.HashSet;

public class 불량사용자_3 {

    static boolean[] check;
    static HashSet<String> set;

    public int solution(String[] user_id, String[] banned_id) {

        check = new boolean[user_id.length];
        set = new HashSet<String>();

        for(int i=0; i<banned_id.length; i++){
            banned_id[i] = banned_id[i].replace('*','.');
        }

        back(0,"",banned_id,user_id);

        return set.size();

    }

    public static void back(int depth, String res, String[] banid, String[] userid){

        if(depth == banid.length){

            String[] arr = res.split(" ");
            Arrays.sort(arr);

            String str = "";
            for(String s : arr) str+=s;
            set.add(str);

            return;

        }

        for(int i=0; i<userid.length; i++){

            if(check[i] || !userid[i].matches(banid[depth])) continue;
            check[i] = true;
            back(depth+1, userid[i]+" "+res, banid, userid);
            check[i] = false;

        }

    }

}
