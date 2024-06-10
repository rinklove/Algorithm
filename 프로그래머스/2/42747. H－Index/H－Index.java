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
            1 1 3 3 3 5 5 6 11 41 
            0 = 10개
        */
        

        while(true) {            
            while(index < length && citations[index] <= hIndex ) {
                index++;
            }
            if(hIndex >= length-index) {
                break;
            }
            hIndex++;
        }
        return hIndex;
    }
}