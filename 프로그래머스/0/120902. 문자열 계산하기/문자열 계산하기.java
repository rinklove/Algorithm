class Solution {
    public int solution(String my_string) {
        int answer = 0;

        String[] split = my_string.split(" ");
        int length = split.length;
        for(int i = 1; i < length; i += 2) {
            if(split[i].equals("-")) {
                 split[i+1] = String.valueOf(Integer.parseInt(split[i-1]) - Integer.parseInt(split[i+1]));
            } else {
                split[i+1] = String.valueOf(Integer.parseInt(split[i-1]) + Integer.parseInt(split[i+1]));
            }
        }
        answer = Integer.parseInt(split[length-1]);
        return answer;
    }
}