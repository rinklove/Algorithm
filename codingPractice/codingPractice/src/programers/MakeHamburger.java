package programers;

import java.util.Arrays;
import java.util.stream.Collectors;


public class MakeHamburger {

	public static void main(String[] args) {
		
		//시간 초과 -> 더 빠른 방법 고안 필요
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		int answer = 0;
		
		 String str = Arrays.stream(ingredient).mapToObj(i -> new String(i+"")).collect(Collectors.joining());
		 while(str.contains("1231")) {
			 str = str.replaceFirst("1231", "");
			answer++;
			System.out.println(str);
		 }
	}
}
