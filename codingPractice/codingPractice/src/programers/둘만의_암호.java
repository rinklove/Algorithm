package programers;

import java.util.Arrays;

public class 둘만의_암호 {

	public static void main(String[] args) {
		
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		String words = "";
		String answer = "";
		
		for(char ch = 'a'; ch <= 'z'; ch++) {
			if(skip.contains(String.valueOf(ch))) continue;
			words += ch;
		}
		System.out.println("words = "+ words);
		String[] wordArray = words.split("");
		String[] tmp = s.split("");
		for(String t : tmp) {
			answer += 	wordArray[(words.indexOf(t)+index)%words.length()];	
		}

		System.out.println(answer);
	}
}
