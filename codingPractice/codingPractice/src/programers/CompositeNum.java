package programers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CompositeNum {

	public static void main(String[] args) {
		//합성수 찾기
		
		int n = 10;
		int[] arr = IntStream.rangeClosed(1, n).toArray();
		int answer = 0;
		
		for(int i = 1;i<arr.length;i++) {
			for(int j = 2;j<arr[i];j++) {
				if(arr[i] % j == 0) {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);
				
	}
}
