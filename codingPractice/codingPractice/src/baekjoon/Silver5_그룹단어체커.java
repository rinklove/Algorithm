package baekjoon;

import java.util.Scanner;

public class Silver5_그룹단어체커 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int count = 0;
		//그룹 단어 체크하는 변수
		boolean flag = true;
		for(int index = 0; index < num; index++) {
			flag= true;
			String str = sc.next();
			
			for(int s = 1; s < str.length(); s++) {
				String curr = str.substring(s, s+1);
				if(!str.substring(s-1, s).equals(curr) && str.substring(0, s).indexOf(curr) != -1) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
