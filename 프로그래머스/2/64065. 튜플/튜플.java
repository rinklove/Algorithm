import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        String tupleStr = s.substring(2, s.length()-2);

        String[] arr = tupleStr.split("\\},\\{");
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        answer = new int[arr.length];


        for (int i = 0; i < arr.length; i++) {
            int[] newArr = Arrays.stream(arr[i].split(",")).mapToInt(Integer::parseInt).toArray();

            for(int n : newArr) {
                if(!set.contains(n)) {
                    set.add(n);
                    answer[i] = n;
                }
            }

        }

        // for (int i :
        //         answer) {
        //     System.out.println("i = " + i);
        // }
        return answer;
    }
}