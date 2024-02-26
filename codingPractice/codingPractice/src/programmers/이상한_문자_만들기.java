package programmers;

public class 이상한_문자_만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "  TRy HElLo  WORLD ";
		String test = "";
		String change= "";

		String[] splitStr = str.split(" ");
		
		for(int i =0; i<splitStr.length;i++) {
			String[] oneChar = splitStr[i].split("");
			
			for(int j=0; j<oneChar.length; j++) {
				
				if(j % 2 == 0) {
					change = oneChar[j].toUpperCase();
				}else {
					change = oneChar[j].toLowerCase();
				}
				test += change;
				System.out.println(test);
			}
			test += " ";
		}
		test = test.substring(test.length()-1);
//		for (String s : splitStr) {
//			test += s + " ");
//		}
//		System.out.println(test);
		
	}

}
