package programers;

public class SmallString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Long.parseLong  생각하자! 오버플로우 발생할 수도 있다
		String t = "10203";
		String p = "15";
		int answer = 0;
		for (int i = 0 ; i < t.length()-p.length()+1; i++) {
			long num1 = Long.parseLong(t.substring(i, i+p.length()));
			long num2 = Long.parseLong(p);
			if(num1 <= num2) {
				
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
