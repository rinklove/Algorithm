package programers;

import java.util.stream.IntStream;

public class 연속된_수의_합 {

	public static void main(String[] args) {
		//num이 짝수 일때..??
		//4	 14	[2, 3, 4, 5]
		int num = 4;
		int total = 14;
		int[] answer = new int[num];
		
		int middleNum = total / num;
		answer = num % 2 ==0 ? IntStream.rangeClosed(middleNum-(num/2-1), middleNum+(num/2)).toArray()
				: IntStream.rangeClosed(middleNum-(num/2), middleNum+(num/2)).toArray();
		
		for(int i : answer) {
			System.out.println(i);
		}
	}
}
