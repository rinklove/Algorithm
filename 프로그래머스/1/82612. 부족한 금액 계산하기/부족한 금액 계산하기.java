class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum =0;
        for(int i =1;i <= count; i++) {
            sum += (i * price);
        }
        answer = sum - money < 0 ? 0 : sum-money;
        return answer;
    }
}