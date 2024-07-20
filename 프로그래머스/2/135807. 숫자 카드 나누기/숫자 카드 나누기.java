import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        answer = compare(arrayA, arrayB);
        return answer;
    }
    
    private int compare(int[] arrayA, int[] arrayB) {
        //두 배열의 중복된 원소를 제거하고 내림차순으로 정렬.
        manufacture(arrayA);
        manufacture(arrayB);
        
        //왼쪽 배열에서 모두 나누어지면서 오른쪽 배열에서 모두 나누어지지 않는 최댓값을 구함 
        int maxA = findMax(arrayA, arrayB);
        int maxB = findMax(arrayB, arrayA);
        return Math.max(maxA, maxB);
    }
    
    private void manufacture(int[] array) {
        array = Arrays.stream(array)
            .distinct()
            .boxed()
            .sorted((i1, i2) -> i2 - i1)
            .mapToInt(i->i)
            .toArray();
    }
    
    private int findMax(int[] target, int[] opposite) {
        int start = target[0];
        while(start > 1) {
            if(isGcd(target, start) && mod(opposite, start)) {
                return start;
            }
            start--;
        }
        return 0;
    }
    
    private boolean isGcd(int[] arr, int num) {
        for(int n : arr) {
            if(n % num != 0) {
                return false;
            }
        }
        return true;
    }
    
    private boolean mod(int[] arr, int num) {
        for(int n : arr) {
            if(n % num == 0) {
                return false;
            }
        }
        return true;
    }
}