import java.util.List;
import java.util.ArrayList;

class Solution {
    private final List<Integer> numberList = new ArrayList<>();
    private int count;
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        getSequence(k);
        int index = 0;

        for(int[] range : ranges) {
            answer[index++] = getArea(range[0], count + range[1]);
        }
        return answer;
    }

    private void getSequence(int k) {
        numberList.add(k);
        while(k != 1) {
            k = k % 2 == 0 ? handleEven(k) : handleOdd(k);
            count++;
            numberList.add(k);
        }
    }

    private int handleEven(int n) {
        return n / 2;
    }

    private int handleOdd(int n) {
        return n * 3 + 1;
    }

    private double getArea(int start, int end) {
        if(start > end) return -1.0;

        double sum = 0.0;
        for(int i = start; i < end; i++) {
            sum += (numberList.get(i) + numberList.get(i+1)) / 2.0;
        }
        return sum;
    }
}