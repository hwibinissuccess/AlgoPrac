package coding2025.Programers.level1.Java;

public class 삼진법뒤집기 {

    public int solution(int n) {

        String str = "";

        while(n != 0){
            str+=n%3;
            n /=3;
        }

        return Integer.parseInt(str, 3);
    }
}
