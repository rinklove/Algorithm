package tmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 리뷰_출력하기 {
	
	// 리뷰 번호 - 메뉴
	public static Map<String, String> map = new HashMap<String, String>();
	public static void main(String[] args) {

		List<board> list = new ArrayList<board>();

		list.add(new board("2019/02/11", "맛있는데", "보쌈", "2", "3"));
		list.add(new board("2019/02/11", "맛있는데", "족보세트", "2", "3"));
		list.add(new board("2019/02/11", "맛있는데", "막국수", "2", "3"));
		list.add(new board("2019/02/11", "맛있는데", "족발", "2", "3"));

		list.add(new board("2019/02/12", "ㅇㅋㅋㅋㅋㅋㅋㅋ", "보쌈", "2", "6"));
		list.add(new board("2019/02/12", "ㅇㅋㅋㅋㅋㅋㅋㅋ", "보쌈", "2", "6"));
		list.add(new board("2019/02/12", "ㅇㅋㅋㅋㅋㅋㅋㅋ", "족보세트", "2", "6"));
		list.add(new board("2019/02/12", "ㅇㅋㅋㅋㅋㅋㅋㅋ", "족발", "2", "6"));

		list.add(new board("2019/02/13", "asdadsadasd", "족발", "2", "7"));
		list.add(new board("2019/02/13", "asdadsadasd", "족발", "2", "7"));
		list.add(new board("2019/02/13", "asdadsadasd", "보쌈", "2", "7"));
		list.add(new board("2019/02/13", "asdadsadasd", "족발세트", "2", "7"));

		list.add(new board("2019/02/14", "존맛탱", "족발세트", "2", "8"));
		System.out.println(list.size());
		list = deleteDistinct(list);
		System.out.println(map.size());
		System.out.println(list.size());
		
		for(board b : list) {
			System.out.println(b);
			System.out.println(map.get(b.getReviewNo()).substring(2));
		}
	}
	
	public static List<board> deleteDistinct(List<board> list) {
		for(board b : list) {
			map.put(b.getReviewNo(), map.getOrDefault(b.getReviewNo(), "")+", " +b.getMenuName());
		}
		
		return list.stream().distinct().collect(Collectors.toList());
	}
}
