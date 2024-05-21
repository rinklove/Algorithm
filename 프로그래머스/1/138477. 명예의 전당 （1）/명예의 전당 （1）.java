import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		heap.add(score[0]);
		int min = heap.peek();
		answer[0] = min;
		for(int i = 1; i < score.length; i++) {
			
			if(i < k ) {
				heap.add(score[i]);
				min = Math.min(min, score[i]);
				answer[i] = min;
			} else {
				if(score[i] > heap.peek()) {
					heap.poll();
					heap.add(score[i]);
					answer[i] = heap.peek();
				} else {
					answer[i] = heap.peek();
				}
			}
		}
        return answer;
    }
}