package coding2025.Programers.level1.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열내마음대로정렬하기 {

    public String[] solution(String[] strings, int n) {

        String[] ans = new String[strings.length];
        List<String> list = new ArrayList<>();

        for(int i=0; i<strings.length; i++){
            list.add(strings[i].charAt(n)+strings[i]);
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i).substring(1,list.get(i).length());
        }

        return ans;
    }

    /*

    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings);

        Arrays.sort(strings, new Comparator<String>(){

            @Override
            public int compare(String s1, String s2){    

                if(s1.charAt(n) > s2.charAt(n)) return 1;
                else if(s1.charAt(n) < s2.charAt(n)) return -1;
                else return 0;
            }
        });

        return strings;
    }
    * */
}
