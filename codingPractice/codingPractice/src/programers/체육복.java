package programers;

import java.util.Arrays;

public class 체육복 {

	public static void main(String[] args) {
		
		//잃어버린 사람이 여벌 체육복이 있는가?
		//옆에 빌릴수 있는가?
		// 5, 12, 24번 틀림 왜?
		
		int n = 5;
		int[] lost = {1,2,3};
		int[] reserve = {2,3,4};
		Arrays.sort(lost);
		Arrays.sort(reserve);
		int answer = 0;
		int[] ableBorrow = {};
		for(int student = 0; student < lost.length; student++) {
			for(int re = 0; re < reserve.length; re++) {
				if(lost[student]==reserve[re]) {
					reserve[re] = Integer.MIN_VALUE;
					lost[student] = Integer.MIN_VALUE;
					break;
				}
			}
		}
		lost = Arrays.stream(lost).filter(i -> i != Integer.MIN_VALUE).sorted().toArray();
		reserve = Arrays.stream(reserve).filter(i -> i != Integer.MIN_VALUE).sorted().toArray();
		
		for(int student = 0; student < lost.length; student++) {
			int current = lost[student];
			boolean isBorrowed = false;
			ableBorrow = Arrays.stream(reserve).map(i -> i)
					.filter(i -> (i == current + 1 || i == current - 1) && i != 0).toArray();

			for(int i =0; i < ableBorrow.length; i++ ) {
				for(int re = 0; re < reserve.length; re++) {
					if (ableBorrow[i] == reserve[re]) {
						reserve[re] = Integer.MIN_VALUE;
						lost[student] = Integer.MIN_VALUE;
						isBorrowed = true;
						break;
					}								
				}
			}
			if(isBorrowed) break;
		}

		answer = (int) (n - Arrays.stream(lost).filter(i -> i != Integer.MIN_VALUE).count());
		System.out.println(answer);
	}
}
