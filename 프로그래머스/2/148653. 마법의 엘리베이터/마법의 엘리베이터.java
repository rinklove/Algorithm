class Solution {
    private int floor;
    public int solution(int storey) {
        int answer = 0;
        floor = storey;
        answer = getMin();
        return answer;
    }
    
    private int getMin() {
        int count = 0;
        while(floor != 0) {
            int c = move();
            count += c;
            floor /= 10;
        } 
        return count;
    }
    
    private int move() {
        int count = 0;
        int digit = floor % 10;
        //마지막 수가 5보다 클 경우 +버튼을 누른다.
        //5보다 작을 경우, -버튼을 누른다.
        if(digit > 5) {
            count = 10 - digit;
            floor += 10 - digit;
        } else if(digit < 5) {
            count = digit;
            floor -= digit;
        } else {
            // 5일 경우다음 숫자 여부에 따라서 반올림 여부를 결정.
            count = 5;
            int next = (floor / 10) % 10;
            round(next);
        }
        return count;
    }
    
    private void round(int digit) {
        if(digit >= 5) {
            floor += 5;
        } else {
            floor -= 5;
        }
    }
}