package programmers;

public class 문자열_나누기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abracadabra";
		int answer  = 0;
		

		while(s.length() != 0) {
			int sameCount = 0;
			int diffCount = 0;
			String first = s.substring(0, 1);
			for(int i =0; i<s.length();i++) {
				String[] arr = s.split("");
				if(arr[i].equals(first)) sameCount++;
				else diffCount++;
				
				if(sameCount==diffCount) break;
			}
			answer++;
			if(sameCount+diffCount >= s.length()) break;
			else
			s = s.substring(sameCount+diffCount);
		}

		
	}

}
