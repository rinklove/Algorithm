package programmers.devmatching;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

	public static void main(String[] args) {
		
		//시간 복잡도는  n2?
		
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] answer = {7, 7};
		List<Integer> list = Arrays.stream(win_nums).mapToObj(i -> new Integer(i)).collect(Collectors.toList());
		for(int i : lottos) {
			if(list.contains(i)) {
				answer[0]--;
				answer[1]--;
			} 
			if(i == 0) {
				answer[0]--;
			}
		}
		answer[0] = answer[0] == 7 ? 6 : answer[0];
		answer[1] = answer[1] == 7 ? 6 : answer[1];
		for(int a : answer) {
			System.out.println(a);
		}
	}
}
