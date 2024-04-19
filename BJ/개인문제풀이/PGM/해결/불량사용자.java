package BJ.개인문제풀이.PGM.해결;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {

    static boolean[] visit;
    static Set<String> set;

    public int solution(String[] user_id, String[] banned_id) {

        visit = new boolean[user_id.length];
        set = new HashSet<>();

        for(int i=0; i<banned_id.length; i++){
            banned_id[i] = banned_id[i].replace('*','.');
        }

        dfs(0,"",user_id, banned_id);

        return set.size();

    }

    public static void dfs(int depth, String res, String[] userid, String[] banid){

        if(depth == banid.length){

            String[] arr = res.split(" ");
            Arrays.sort(arr);

            String str = "";
            for(String s : arr) str+=s;
            set.add(str);

            return;

        }

        for(int i=0; i<userid.length; i++){

            if(visit[i] || !userid[i].matches(banid[depth])) continue;

            visit[i] = true;
            dfs(depth+1, userid[i]+" "+res, userid, banid);
            visit[i] = false;

        }

    }

}
