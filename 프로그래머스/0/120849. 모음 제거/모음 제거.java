class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] str = {"a","e","i","o","u"};
            
            for(int i=0;i<str.length;i++) {
                answer = my_string.replace(str[i], "");
                my_string = answer;
            }
        return answer;
    }
}