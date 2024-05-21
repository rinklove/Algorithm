class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(int i =0; i<babbling.length;i++) {
            babbling[i] = replace(babbling[i]);
            try{
                Integer.parseInt(babbling[i]);
                    answer++;
                
            } catch(Exception e) {
                continue;
            }
        }
        return answer;
    }
    
    public String replace(String str) {
        str = str.replaceAll("aya", "1");
        str = str.replaceAll("ye", "2");
        str = str.replaceAll("woo", "3");
        str = str.replaceAll("ma", "4");
        return str;
    }
}

