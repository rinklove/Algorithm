class Solution {
    public int solution(int hp) {
        int answer = 0;
        int damage = 5;
        
        while (hp != 0) {
            int amount = hp  / damage;
            hp %= damage;
            answer += amount;
            damage -= 2;
        }    
        
        
        return answer;
    }
}