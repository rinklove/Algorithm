package programmers;

import java.util.PriorityQueue;

public class 명예의_전당1 {

	//명예의 전당
	public static void main(String[] args) {
		
		//최소 힙?
		int k = 4;
		int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
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

	}
}
