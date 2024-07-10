class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = length;
        
        for(int i = 1; i <= length / 2; i++) {
            int cmp = compress(s, i);
            answer = Math.min(answer, cmp);
        }
        return answer;
    }
    
    private int compress(String str, int length) {
        StringBuilder sb = new StringBuilder();
        int end = str.length();
        int count = 1;
        
        String target = str.substring(0, length);
        sb.append(target);

        for(int index = length; index <= end; index += length) {
            String current = index + length <= end ? 
                str.substring(index, index+length) : str.substring(index);
            
            if(current.equals(target)) {
                count++;
            } else {
                if(count > 1) {
                    int insert = sb.toString().indexOf(target);
                    sb.insert(insert, count);
                    count = 1;
                }
                sb.append(current);
                target = current;
            }
        }
        return sb.length();
    }
}