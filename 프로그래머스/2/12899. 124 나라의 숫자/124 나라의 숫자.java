class Solution {
    public String solution(int n) {
        int current = n;
        StringBuilder sb = new StringBuilder();
        
        while(current > 3) {
            int mod = current % 3;
            current /= 3;
            if(mod == 0) {
                current--;
                mod = 3;
            }
            sb.append(insert(mod));
        }
        sb.append(insert(current));
        return sb.reverse().toString();
    }
    
    private int insert(int number) {
        return switch(number) {
            case 1 -> 1;
            case 2 -> 2;
            default -> 4;
        };
    }
}