import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = isTree(numbers[i]);
        }
        return answer;
    }
    
    private int getHeight(String str) {
        int n = 0;
        int length = str.length();
        while(length >= Math.pow(2, n)) {
            n++;
        }
        return n;
    }
    
    private int getNodeCount(String str) {
        return (int) Math.pow(2, getHeight(str)) - 1;
    }
    
    private int isTree(long number) {
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toBinaryString(number));
        int count = getNodeCount(sb.toString());
        for(int c = sb.toString().length(); c < count; c++) {
            sb.insert(0, "0");
        }
        String tree = sb.toString();
        
        return dfs(tree, 0, count);
    }
    //dfs + binarySearch
    private int dfs(String tree, int start, int end) {
        if(end - start == 1) return 1;
        
        int mid = (end + start) / 2;
        if(tree.charAt(mid) == '0') {
            int subStart = start;
            if(start != 0) subStart++;
            for(int s = subStart; s < end; s++) {
                if(tree.charAt(s) == '1') return 0;
            }
        }
        
        int left = dfs(tree, start, mid);
        int right = dfs(tree, mid, end);
        return left == 1 && right == 1 ? 1 : 0;
    }
}