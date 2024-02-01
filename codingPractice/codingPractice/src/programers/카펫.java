package programers;

import java.util.stream.IntStream;

public class 카펫 {

    public static void main(String[] args) {

        int[] solution = solution(10, 2);
        for (int per :
                solution) {
            System.out.println("per = " + per);
        }
    }

    public static int[] solution(int brown, int yellow) {
        /**
         * 가로 >= 새로
         * 2a+2b = 14, a+b = 7, a = 7 - b;
         * (a-2)*(b-2) = ab - 14 + 4 = 2, (7-b)b = 12
         *
         * => b^2 -7b + 12 = 0;
         * 3 or 4
         *
         * 48
         * 1 2 3 4 6 8 12 16 24 48
         * 52
         * 1 2 4 13 26 52
         * 50
         * 1 2 5 10 25 50
         */
        int[] answer = new int[2];
        int width = brown + yellow;

        int[] arr = IntStream.rangeClosed(3, width / 3).filter(i -> width % i == 0).toArray();


        int size = arr.length;
        for (int r = 0; r <=  size / 2; r++) {
            if(2*arr[r] + 2*arr[size-1-r] == brown+4 && (arr[r]-2)*(arr[size-1-r]-2) == yellow) {
                answer[0] = Math.max(arr[r], arr[size-1-r]);
                answer[1] = Math.min(arr[r], arr[size-1-r]);
                break;
            }
        }


        return answer;
    }
}
