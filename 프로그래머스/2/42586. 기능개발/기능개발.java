import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> count = new ArrayList<>();

        Stack<Integer> jobs = new Stack<>();
        Stack<Integer> s = new Stack<>();


        for(int index = progresses.length-1; index >= 0; index--) {
            jobs.push(progresses[index]);
            s.push(speeds[index]);
        }

        while(true) {
            int completed = 0;


            if(jobs.isEmpty()) break;
            else {
                for(int n = 0; n < s.size(); n++) {
                    jobs.set(n, jobs.elementAt(n)+s.elementAt(n));
                }

                while(!jobs.isEmpty() && jobs.peek() >= 100) {
                    jobs.pop();
                    s.pop();
                    completed++;
                }

                if(completed != 0) {
                    count.add(completed);
                }
            }
        }
        answer = count.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}