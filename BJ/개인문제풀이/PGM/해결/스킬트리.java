package BJ.개인문제풀이.PGM.해결;

public class 스킬트리 {

    public int solution(String skill, String[] skill_trees) {

        int ans = 0;

        for(int i=0; i<skill_trees.length; i++){
            skill_trees[i] = skill_trees[i].replaceAll("[^"+skill+"]", "");
        }

        for(int i=0; i<skill_trees.length; i++){
            boolean flag = true;
            for(int j=0; j<skill_trees[i].length(); j++){
                if(skill.charAt(j) != skill_trees[i].charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag) ans++;
        }

        return ans;

    }
}
