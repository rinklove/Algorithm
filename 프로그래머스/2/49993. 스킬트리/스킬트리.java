class Solution {
     public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for(String s : skill_trees) {
                answer += checkSkillTree(skill, s);
            }


            return answer;
        }

        private int checkSkillTree(String skill, String skill_tree) {
            StringBuilder sb = new StringBuilder();
            
            String[] split = skill_tree.split("");
            
            for(String s : split) {
                if(skill.contains(s)) {
                    sb.append(s);
                }
            }
            
            String result = sb.toString();
            return skill.startsWith(result) ? 1 : 0;
        }
}