import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
		ArrayList<Integer> list = new ArrayList<Integer>();
		List<Integer> answerList = new ArrayList<>();
		//자르고 정렬하고 인덱스 가져오면 끝 아닌감
		//역시 런타임 에러난다-> 시간 복잡도를 줄일 수 있나?
		for(int i = 0; i < commands.length; i++) {
			for(int index = commands[i][0]; index <=commands[i][1]; index++) {
				list.add(array[index-1]);
			}
			 list.sort(null);
			 answerList.add(list.get(commands[i][2]-1));
			 list.clear();
		}
		answer = new int[answerList.size()];
		for(int i =0; i<answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
        return answer;
    }
}