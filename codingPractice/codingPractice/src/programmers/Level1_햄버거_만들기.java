package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Level1_햄버거_만들기 {

	/*
		기존 풀이 -> 시간 초과 발생
		public int solution(int[] ingredient) {
			int answer = 0;

			String str = Arrays.stream(ingredient).mapToObj(i -> new String(i+"")).collect(Collectors.joining()).substring(0,4);

			for(int i = 4; i < ingredient.length; i++) {
				str += ingredient[i];

				if(str.contains("1231")) {
					str = str.replace("1231", "");
					answer++;
				}
			}
			return answer;
		}
	*/

	// 5, 12번 시간초과 -> 재귀도 아니고 좀 더 빨리 할 수 있는 방법이 있나? 고민 해봐야 할 듯
	public static void main(String[] args) {

		int solution = solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1});
		System.out.println("solution = " + solution);
	}

	private static int solution(int[] ingredient) {
		int answer = 0;
		String str = Arrays.stream(ingredient).mapToObj(String::valueOf).collect(Collectors.joining(""));

		answer = makeBurger(str);
		return answer;
	}

	private static int makeBurger(String str) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		int index = sb.indexOf("1231", -1);
		while(index > -1) {
			System.out.println("index = " + index);
			sb.delete(index, index+4);
			count++;
			index -= 4;
			index = sb.indexOf("1231", index);
		}

		return count;
	}
}
