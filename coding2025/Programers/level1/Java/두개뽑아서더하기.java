package coding2025.Programers.level1.Java;

import java.util.HashSet;
import java.util.Set;

public class 두개뽑아서더하기 {

    public int[] solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
