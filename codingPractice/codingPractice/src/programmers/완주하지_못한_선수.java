package programmers;

import java.util.Arrays;

public class 완주하지_못한_선수 {

	public static void main(String[] args) {
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		int mismatch = Arrays.mismatch(participant, completion);
		System.out.println(mismatch);
		
		String answer = participant[mismatch];
	}
}
