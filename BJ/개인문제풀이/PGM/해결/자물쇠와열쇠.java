package BJ.개인문제풀이.PGM.해결;

public class 자물쇠와열쇠 {

    static int keyLen;
    static int lockLen;
    static int[][] map;
    static int mapLen;

    public boolean solution(int[][] key, int[][] lock) {

        keyLen = key.length;
        lockLen = lock.length;
        map = new int[keyLen*2+lockLen-2][keyLen*2+lockLen-2];
        mapLen = map.length;

        for(int i=0; i<lockLen; i++){
            for(int j=0; j<lockLen; j++){
                map[keyLen-1+i][keyLen-1+j] = lock[i][j];
            }
        }

        for(int i=0; i<4; i++){

            if(check(key)){
                return true;
            }

            rotate(key);

        }

        return false;

    }

    public static boolean check(int[][] key){

        for(int i=0; i<mapLen-keyLen+1; i++){
            for(int j=0; j<mapLen-keyLen+1; j++){
                for(int a=0; a<keyLen; a++){
                    for(int b=0; b<keyLen; b++){

                        map[i+a][j+b] += key[a][b];

                    }
                }

                boolean flag = true;

                for(int a=keyLen-1; a<keyLen-1+lockLen; a++){
                    for(int b=keyLen-1; b<keyLen-1+lockLen; b++){
                        if(map[a][b] != 1){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) break;
                }

                if(flag) return true;

                for(int a=0; a<keyLen; a++){
                    for(int b=0; b<keyLen; b++){

                        map[i+a][j+b] -= key[a][b];

                    }
                }

            }
        }

        return false;

    }

    public static void rotate(int[][] key){

        int[][] temp = new int[keyLen][keyLen];

        for(int i=0; i<keyLen; i++){
            for(int j=0; j<keyLen; j++){
                temp[i][j] = key[keyLen-1-j][i];
            }
        }

        for(int i=0; i<keyLen; i++){
            for(int j=0; j<keyLen; j++){
                key[i][j] = temp[i][j];
            }
        }



    }


}
