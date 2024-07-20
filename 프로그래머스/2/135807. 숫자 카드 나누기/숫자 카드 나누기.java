import java.util.Arrays;
/*
    방안 1. 배열의 중복을 제거+내림차순 정렬하고 
            제일 큰 수부터 시작해서 값을 감소시키며 최대 공약수를 찾음 -> 성공
            하지만 어차피 제일 큰수를 제외한 나머지 수는 안나누어지는 점을 발견 
            + 처리 시간도 긴 문제 발생
            
    방안 2. 배열의 오름차순으로 정렬 후, 제일 작은 수부터 시작해서 값을 감소 -> 성공
            방안 1보다 처리 속도도 빨라졌음.
*/
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        answer = compare(arrayA, arrayB);
        return answer;
    }
    
    private int compare(int[] arrayA, int[] arrayB) {
        //두 배열을 오름차순으로 정렬.
        sort(arrayA);
        sort(arrayB);
        
        //왼쪽 배열에서 모두 나누어지면서 오른쪽 배열에서 모두 나누어지지 않는 최댓값을 구함 
        int maxA = findMax(arrayA, arrayB);
        int maxB = findMax(arrayB, arrayA);
        return Math.max(maxA, maxB);
    }
    
    private void sort(int[] array) {
        // Arrays.sort(Arrays.stream(array).distinct().toArray());
        Arrays.sort(array);
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