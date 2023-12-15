package programers;

import java.util.Arrays;

public class 최대값과_최소값 {

	public static void main(String[] args) {
		
		String s = "1 2 3 4";
		String answer = "";
		String[] arr = s.split(" ");
		
		answer = Arrays.stream(arr).mapToInt(num -> Integer.parseInt(num)).min().getAsInt() + 
		" " + Arrays.stream(arr).mapToInt(num -> Integer.parseInt(num)).max().getAsInt();
	}
}
