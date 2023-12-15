package programers;

public class 시저_암호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//시저 암호
		
		String s = "a B z";
		int n = 4;
		
		String[] strArr = s.split("");
		char ch;
		System.out.println();
		String answer = "";
		for(int i = 0; i<s.length();i++) {
			if(strArr[i].equals(" ")) 
				answer += strArr[i];
			else {
				ch = strArr[i].charAt(0);
				if(ch + n >'z') {
					ch = (char) (ch+n-26);
				} else if(ch== 'a') {
					ch = (char) (ch+n);
				} else if(ch+n > 'Z' && ch < 'a') {
					ch = (char) (ch+n-26);
				} else {
					ch = (char) (ch+n);
				}
				answer = answer + ch;
			}
		}
		System.out.println(answer);
	}

}
