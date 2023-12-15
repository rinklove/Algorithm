package programers;

public class 삼총사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//인덱스 겹칠 떄 제거 해줬고또 무슨 상황에서 제거해야하누...
		
//		int[] people = {-2, 3, 0, 2, -5};
		int[] people = {-3, -2, -1, 0, 1, 2, 3};
		int answer = 0;
		for(int i = 0; i<people.length-2; i++) {
			for(int j =i+1; j<people.length-1;j++) {

				for(int k =j+1; k<people.length;k++) {

					if((people[i] + people[j] + people[k]) == 0) answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}
