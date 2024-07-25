import java.util.Arrays;
class Solution {
    public int solution(String[] babbling) {
        return (int) Arrays.stream(babbling)
            .map(b -> b.replaceAll("ayaaya|yeye|woowoo|mama", " "))
            .map(b -> b.replaceAll("aya|ye|woo|ma", ""))
            .filter(b -> b.isEmpty()).count();
    }
}