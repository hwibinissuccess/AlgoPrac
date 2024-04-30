package BJ.개인문제풀이.PGM.해결;

public class 풍선터트리기 {

    public int solution(int[] a) {

        int ans = 0;

        if(a.length == 1) return 1;
        if(a.length == 2) return 2;

        int leftMin = a[0];
        int[] rightMin = new int[a.length];
        rightMin[a.length-1] = a[a.length-1];

        for(int i=a.length-2; i>=0; i--){
            rightMin[i] = Math.min(rightMin[i+1], a[i]);
        }

        for(int i=0; i<a.length; i++){

            if(!(leftMin<a[i] && rightMin[i]<a[i])){
                ans++;
            }

            leftMin = Math.min(leftMin, a[i]);

        }

        return ans;

    }

}
