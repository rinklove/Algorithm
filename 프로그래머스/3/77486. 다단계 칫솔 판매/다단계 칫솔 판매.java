/*
    트리? dfs? 재귀?
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
    
    //각 판매원의 순서에 맞게 판매 실적 금액 설정하는 메서드
    private int[] getIncomes(int[] answer, String[] enroll) {
        for(int i =0; i < enroll.length; i++) {
            answer[i] = income.get(enroll[i]);
        }
        return answer;
    }
    
    //판매원과 추천인 초기 세팅하는 메서드
    private void init(String[] enroll, String[] referral) {
        for(int i = 0; i < enroll.length; i++) {
            income.put(enroll[i], 0);
            relation.put(enroll[i], referral[i]);
        }
    }
    
    //각 판매원의 판매 실적 설정하는 메서드
    private void setIncome(String seller, int price) {
        int rate = 0;
        //판매인이 민호이거나, 판매 금액이 0원이면 종료
        if(price == 0 || !income.containsKey(seller)) return;
        
        if(price >= 10) {
            rate = price / 10;
            price -= rate;
        }
        
        //판매금액의 10%를 상납
        //판매원의 추천인도 해당 금액만큼 벌은 것과 동일하므로, 본인의 추천인에게도 10&를 상납하는 구조
        //-> 재귀로 호출
        income.put(seller, income.get(seller)+price);
        setIncome(relation.get(seller), rate);
    }
}