package programers;

public class 옹알이1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//옹알이 aya ye woo ma를 1,2,3,4로 치환 후 parseint 처리
		//Character.isDigit() 또는 Integer.parseInt()(얘는 예외처리 필요)
		
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		int answer = 0;
		
		for(int i =0; i < babbling.length; i++) {			
			babbling[i] = babbling[i].replaceAll("ayaaya|yeye|woowoo|mama", " ");
			babbling[i] = babbling[i].replaceAll("aya|ye|woo|ma", "");
			if(babbling[i].equals("")) answer++;
		}



	
	}

}
