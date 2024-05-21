class Solution {
    public String solution(String rsp) {
        String answer = "";
        char result  = '\0';
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i < rsp.length(); i++) {
            char c = rsp.charAt(i);
            
            result = switch(c) {
                case '2' -> '0';
                    case '0' -> '5';
                    default -> '2';
            };
            
            sb.append(result);
        }
        
        answer = sb.toString();
        return answer;
    }
}