package programmers;

import java.util.Arrays;

/**
 *점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
 * 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
 * 학생들의 번호는 체격 순으로 매겨져 있어,
 * 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
 * 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
 * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
 *
 * 전체 학생의 수 n,
 * 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
 * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
 * 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 */
public class Level1_체육복 {

	public static void main(String[] args) {

		int solution = solution(5, new int[]{3, 4}, new int[]{4, 3});
		System.out.println("solution = " + solution);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] uniformCount = new int[n];

		//모든 학생이 체육복을 가지고 있음
        Arrays.fill(uniformCount, 1);
		Arrays.sort(lost);

		//체육복을 잃어버린 학생
		for (int l : lost) {
			uniformCount[l-1]--;
		}

		//여분의 체육복을 가져온 학생
		for (int r : reserve) {
			uniformCount[r-1]++;
		}
		
		for(int i : uniformCount) {
			System.out.println("i = " + i);
		}

		//빌려줄 수 있는 지 판단
		for (int l : lost) {
			l--;
			if(uniformCount[l] == 0) {
				if(isAbleToBorrow(l-1, n) && uniformCount[l-1] == 2) {
					uniformCount[l-1]--;
					uniformCount[l]++;
				} else if(isAbleToBorrow(l+1, n) && uniformCount[l+1] == 2) {
					uniformCount[l+1]--;
					uniformCount[l]++;
				}
			}
		}

		answer = (int) Arrays.stream(uniformCount).filter(i -> i != 0).count();
		return answer;
	}

	public static boolean isAbleToBorrow(int index, int length) {
		return index >= 0 && index <= length-1;
	}
}
