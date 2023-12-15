package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitTwo {

	public static void main(String[] args) {
		String my_string = " i    love  you";
		String[] answer;
		
		List<String> list = Arrays.asList(my_string.trim().split(" ", -1));
		List<String> newList = new ArrayList();
		 
		for(int i =0; i< list.size(); i++) {
			if(!list.get(i).equals("")) {
				newList.add(list.get(i));
			}
		}
		
		answer = new String[newList.size()]; 
		newList.toArray(answer);
	}
}
