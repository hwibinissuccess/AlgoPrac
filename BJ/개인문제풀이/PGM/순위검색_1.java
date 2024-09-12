package BJ.개인문제풀이.PGM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 순위검색_1 {



    static HashMap<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {

        int[] ans = new int[query.length];
        map = new HashMap<String, List<Integer>>();

        for(int i=0; i<info.length; i++){
            String[] p = info[i].split(" ");
            makeSentence(p, "",0);
        }

        for(String key : map.keySet())
            Collections.sort(map.get(key));

        for(int i=0; i<query.length; i++){
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            ans[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return ans;

    }

    public static int binarySearch(String key, int score){

        List<Integer> list = map.get(key);
        int start=0, end = list.size()-1;

        while(start <= end){

            int mid = (start+end)/2;

            if(list.get(mid) < score)
                start = mid +1;
            else
                end = mid-1;
        }

        return list.size()-start;
    }

    public static void makeSentence(String[] p, String str, int cnt){

        if(cnt==4){
            if(!map.containsKey(str)){
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }

        makeSentence(p, str+"-", cnt+1);
        makeSentence(p, str+p[cnt], cnt+1);
    }

}
