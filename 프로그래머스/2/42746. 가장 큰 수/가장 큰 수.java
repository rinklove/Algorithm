import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        return getString(numbers);
    }
    
    private String getString(int[] numbers) {
        String[] arr = getArr(numbers);
        Arrays.sort(arr, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        return arr[0].equals("0") ? "0" : String.join("", arr);
    }
    
    private String[] getArr(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int n = 0; n < numbers.length; n++) {
            arr[n] = String.valueOf(numbers[n]);
        }
        return arr;
    }
    
}