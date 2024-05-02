package BJ.개인문제풀이.PGM.해결;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 튜플 {

    public List<Integer > solution(String s) {

        List<Integer> ans = new ArrayList<>();
        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2).replace("},{","-");
        String[] nums = s.split("-");

        Arrays.sort(nums, (o1, o2) -> o1.length()-o2.length());

        for(int i=0; i<nums.length; i++){
            String[] str = nums[i].split(",");
            for(int j=0; j<str.length; j++){
                if(!ans.contains(Integer.parseInt(str[j]))){
                    ans.add(Integer.parseInt(str[j]));
                }
            }
        }

        return ans;

    }

}
