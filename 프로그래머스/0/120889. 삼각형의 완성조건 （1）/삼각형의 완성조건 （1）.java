class Solution {
    public int maxIndex(int[] arr) {
        int max=arr[0];
        int maxIndex = 0;
        
        for(int i=1;i<arr.length;i++) {
            if(arr[i] > max) {
                maxIndex=i;
                max=arr[maxIndex];
            }
        }
        return maxIndex;
    }
    
    public int solution(int[] sides) {
        int maxIndex = maxIndex(sides);
        int sum=0;
        for(int i :sides) {
            sum += i;
        }
        sum -= sides[maxIndex];

        return sides[maxIndex] < sum? 1:2;
    }
}