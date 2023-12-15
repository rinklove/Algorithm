package programers;

import java.util.ArrayList;

public class ad제거하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] str ={"and","notad","abcd"};
		
		ArrayList<String> list = new ArrayList<>();
		
		for(int i =0; i<str.length; i++) {
			if(str[i].contains("ad")) continue;
			list.add(str[i]);
		}
		
	}

}
