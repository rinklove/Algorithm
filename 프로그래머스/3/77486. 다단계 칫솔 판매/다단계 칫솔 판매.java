/*
    트리 구조? dfs?
    상납금 계산 방법: (모든 형태의 수익) / 10;
*/
import java.util.Map;
import java.util.HashMap;
class Solution {
    private final Map<String, Integer> income = new HashMap<>();
    private final Map<String, String> relation = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        init(enroll, referral);
        //각 수익에 대해서 계산
        for(int i = 0; i < seller.length; i++) {
            setIncome(seller[i], amount[i]*100);
        }
        
        return getIncomes(answer, enroll);
    }
    
    private int[] getIncomes(int[] answer, String[] enroll) {
        for(int i =0; i < enroll.length; i++) {
            answer[i] = income.get(enroll[i]);
        }
        return answer;
    }
    
    private void init(String[] enroll, String[] referral) {
        for(int i = 0; i < enroll.length; i++) {
            income.put(enroll[i], 0);
            relation.put(enroll[i], referral[i]);
        }
    }
    
    private void setIncome(String seller, int price) {
        int rate = 0;
        if(price == 0 || !income.containsKey(seller)) return;
        
        if(price >= 10) {
            rate = price / 10;
            price -= rate;
        }
        
        income.put(seller, income.get(seller)+price);
        setIncome(relation.get(seller), rate);
        
    }
}