package programers.kakao;

import java.util.ArrayList;
import java.util.List;

public class 비밀지도 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//정수를 이진수로 표현
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		// 22 14: 0, 0 -> 11 7: 1, 1 -> 5, 3: 1, 1 
		// 숫자가 너무 큰 차이가 날때 처리 방법을 생각
		String[] answer = new String[n];
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i<arr1.length; i++) {
			answer[i] = "";
			for(int j = 0; j<n; j++) {
				if(arr1[i] % 2 == 0 && arr2[i] % 2 ==0) list.add(" ");
				else list.add("#");
				arr1[i] /=2;
				arr2[i] /=2;				
			}
			for(int k =0; k<list.size();k++) {
				answer[i] += list.get(list.size()-1-k);
			}
			list.clear();
		}
			
		
		for(String s : answer) {
			System.out.println(s);
		}
		
	}

}
