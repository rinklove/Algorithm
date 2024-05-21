class Solution {
    
    StringBuilder total = new StringBuilder();
    StringBuilder per = new StringBuilder();
    
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int number = 0;
        
        //모든 사람이 t개만큼의 문자를 말할 수 있을 때까지 수행
        while(total.length() < t * m) {
            String numStr = getNumString(number, n);
            
            total.append(numStr);
            number++;
            per.setLength(0);
        }
        
        for(int i = 0; i < t; i++) {
            answer += total.charAt(p-1);
            p += m;
        }
        return answer;
    }
    
    
    /**
        number는 숫자
        n은 진수
        10진수의 수를 n진수로 변환하는 메소드
    */
    private String getNumString(int number, int n) {
        do {
            int mod = number % n;
            
            String str = switch(mod) {
                case 10 -> "A"; 
                case 11 -> "B"; 
                case 12 -> "C"; 
                case 13 -> "D"; 
                case 14 -> "E"; 
                case 15 -> "F"; 
                default -> String.valueOf(mod); 
            };
            
            per.append(str);
            number /= n;
        } while(number != 0);
        return per.reverse().toString();
    }
}