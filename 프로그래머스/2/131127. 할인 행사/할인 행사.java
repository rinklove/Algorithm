import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private final Map<String, Integer> map = new HashMap<>();
    //
    private final Integer MEMBERSHIP_DAY = 10;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < discount.length-MEMBERSHIP_DAY+1; i++) {
            setMap(want, number);
            buy(Arrays.copyOfRange(discount, i, i+MEMBERSHIP_DAY));
            if(isEmpty()) answer++;
        }
        return answer;
    }
    
    private void setMap(String[] want, int[] number) {
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
    }
    
    //원하는 품목을 10개씩 구매
    private void buy(String[] discount) {
        
        //첫 날에 품목을 살 수 있으면 나머지 품목도 회원 자격으로 구매한다.
        if(canBuy(discount[0])) {
            for(String d : discount) {
                if(!canBuy(d)) continue;

                map.put(d, map.get(d)-1);
            }
        }
    }
    
    //첫 날에 품목을 살 수 있는 지 확인하는 메서드(회원으로 등록하는 지 확인) &
    //원하는 품목을 구매할 수 있는 지 확인하는 메서드.
    private boolean canBuy(String first) {
        return map.get(first) != null;
    }
    
    //원하는 품목을 모두 구매했는 지 확인하는 메서드
    private boolean isEmpty() {
        return map.entrySet().stream().filter(i -> i.getValue() > 0).count() == 0;
    }
}