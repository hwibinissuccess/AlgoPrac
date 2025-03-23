package coding2025.Programers.level1.Java;

public class 하샤드수 {


    public boolean solution(int x) {

        int num = x;
        int sum = 0;

        while(num != 0){
            sum += num%10;
            num /=10;
        }

        return x%sum == 0 ? true : false;

    }
}
