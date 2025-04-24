package coding2025.Programers.level1.Java;
import java.util.*;

public class 포켓몬 {

    public int solution(int[] nums) {

        int max = nums.length/2;

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }

        if(max >= set.size()) return set.size();
        else return max;
    }
}
