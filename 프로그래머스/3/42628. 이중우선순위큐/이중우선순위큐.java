import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(String oper : operations) {
			String[] current = oper.split(" ");
			
			if(current[0].equals("I")) {
				heap.add(Integer.parseInt(current[1]));
			}
			else {
				//최소 힙에서 최대값 찾기(다 뺐다가 다시 넣기)
				if(current[1].equals("1")) {
					heap.stream().forEach(i -> maxHeap.add(i));
					heap.clear();
					maxHeap.poll();
					maxHeap.stream().forEach(i -> heap.add(i));
					maxHeap.clear();
				} else {
					heap.poll();
				}
			}
		}
		answer[0] = heap.stream().mapToInt(i -> i).max().orElse(0);
		answer[1] = heap.stream().mapToInt(i -> i).min().orElse(0);
		
		System.out.println(answer[0]);
		System.out.println(answer[1]);
        return answer;
    }
}