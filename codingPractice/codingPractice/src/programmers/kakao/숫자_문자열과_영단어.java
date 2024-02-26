package programmers.kakao;

public class 숫자_문자열과_영단어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 리턴값은 int 범위 내
		
		int answer = 0;
		int i= 1;
		String[] numString = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
		String s = "sixsixsixsix";
		try {
			answer = Integer.parseInt(s);
		} catch(Exception e ) {
			for(String str : numString) {
				s= s.replaceAll(str, i+"");
				i++;
			}
			answer = Integer.parseInt(s);
		} 
	
		System.out.println(answer);
	}
}
