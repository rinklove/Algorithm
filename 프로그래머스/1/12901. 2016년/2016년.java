import java.time.LocalDate;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        LocalDate date = LocalDate.of(2016, a, b);
		answer = date.getDayOfWeek().name().substring(0,3);
        return answer;
    }
}