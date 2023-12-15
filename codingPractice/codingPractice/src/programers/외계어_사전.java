package programers;

import java.util.Arrays;

public class 외계어_사전 {

	public static void main(String[] args) {
		
		//길이 같고, 
		String[] spell = {"s", "o", "m", "d"};
		String[] dic = {"moos", "dzx", "smm", "sunmmo", "som"};
		Arrays.stream(dic).filter(s-> s.length() == spell.length).toArray();
		int answer = 0;
		boolean isExist = false;
		
		for(int i = 0; i<dic.length; i++) {
			for(int j = 0; j< spell.length; j++) {
				if(dic[i].contains(spell[j]) && dic[i].indexOf(spell[j]) == dic[i].lastIndexOf(spell[j])) {
					isExist = true;
				} else {
					isExist = false;
					break;
				}
			}
			if(isExist) break;
		}
		answer = isExist? 1 : 2;
		System.out.println(answer);
	}
}
