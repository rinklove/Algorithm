class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int length = number.length() - k;
        int start = 0;

        for(int i = 0; i < length; i++) {
            char max = '0';
            int maxIndex = start;
            // 최대값을 찾을 수 있는 범위 계산
            int end = number.length() - (length - i);
            for(int j = start; j <= end; j++) {
                if(number.charAt(j) > max) {
                    max = number.charAt(j);
                    maxIndex = j;
                }
            }
            answer.append(max);
            start = maxIndex + 1; // 다음 탐색 시작점 갱신
        }

        return answer.toString();
    }
}
