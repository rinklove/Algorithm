package programmers;

import java.util.Arrays;

public class 문자열_내_마음대로_정렬하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 1;
		String str;
		String[] strings = {"ae","be","ce","ae"};
		//["abcd", "abce", "cdx"]
		String[] answer = new String[strings.length];
//		Arrays.sort(strings);
				
		for(int i =0; i<strings.length; i++) {

			for(int j =i+1; j<strings.length;j++) {			
				
				if(strings[i].charAt(n) > strings[j].charAt(n)) {
					str = strings[j]; 
					strings[j] = strings[i];
					strings[i] = str;
				}				
				if((strings[i].charAt(n) == strings[j].charAt(n)) 
						&& strings[i].compareTo(strings[j])>0)  {
					str = strings[j]; 
					strings[j] = strings[i];
					strings[i] = str;
				}
			}
		}
		answer = strings;
		for(int i =0; i<strings.length;i++) {
			System.out.println(strings[i]);
		}
	}
}
//문자열 앞에 기준 문자열 붙이고 정렬 -> 이 생각을 못했네

/*
 * import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        //문자열 앞에 기준 문자열을 추가해서 ArrayList에 저장
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        //정렬
        Collections.sort(arr);
        answer = new String[arr.size()];
        ArrayList 에 있는 값을 배열에 하나씩 할당
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }
}*/
