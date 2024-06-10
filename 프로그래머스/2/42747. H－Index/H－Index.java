import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int hIndex = 0;
        int length = citations.length;
        int index = 0;
        
        //논문의 인용 횟수를 오름차순으로 정렬 - 01356
        Arrays.sort(citations);
        /*
            0번 이상 인용된 논문 - 5개
            1번 이상 인용된 논문 - 4개
            2번 이상 인용된 논문 - 3개
            3번 이상 인용된 논문 - 3개
            4번 이상 인용된 논문 - 2개(거짓)
        */
        while(true) {          
            //논문 중에서 현재 hIndex보다 낮은 인용수의 논문은 건너뜀
            while(index < length && citations[index] <= hIndex) {
                index++;
            }
            
            //남은 논문의 개수가 hIndex보다 작으면 종료
            if(hIndex >= length-index) {
                break;
            }
            //hIndex값 증가
            hIndex++;
        }
        return hIndex;
    }
}