package programmers;

import java.util.ArrayList;
import java.util.List;

public class K번째_수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//K번째수 - Arrays.copyOfRange() 사용해서 해보기
	
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = new int[commands[0].length];
		List<Integer> list = new ArrayList<>();
		List<Integer> answerList = new ArrayList<>();
		//자르고 정렬하고 인덱스 가져오면 끝 아닌감
		//역시 런타임 에러난다-> 시간 복잡도를 줄일 수 있나?
		for(int i = 0; i < answer.length; i++) {
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
	}
}
