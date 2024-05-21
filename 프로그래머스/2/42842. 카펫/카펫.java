import java.util.stream.IntStream;

class Solution {
    public int[] solution(int brown, int yellow) {
         int[] answer = new int[2];
        int width = brown + yellow;

        int[] arr = IntStream.rangeClosed(3, width / 3).filter(i -> width % i == 0).toArray();

        int size = arr.length;
        for (int r = 0; r <= size / 2; r++) {
            if(2*arr[r] + 2*arr[size-1-r] == brown+4 && (arr[r]-2)*(arr[size-1-r]-2) == yellow) {
                answer[0] = Math.max(arr[r], arr[size-1-r]);
                answer[1] = Math.min(arr[r], arr[size-1-r]);
                break;
            }
        }


        return answer;
    }
}