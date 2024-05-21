import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
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
    
    public boolean isAbleToBorrow(int index, int length) {
		return index >= 0 && index <= length-1;
	}
}