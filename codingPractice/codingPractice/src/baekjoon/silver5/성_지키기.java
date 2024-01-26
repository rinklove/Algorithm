package baekjoon.silver5;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 성_지키기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int colAdd = 0;
		int rowAdd = 0;
		
		//String
		String[] castle = new String[row];
		Set<Integer> person = IntStream.rangeClosed(0, col-1).boxed().collect(Collectors.toSet());
		
		//가로로 체크
		for(int i = 0; i < row; i ++) {
			castle[i] = sc.next();
			if(castle[i].contains("X")) {

				boolean isEmpty = true;
				Iterator<Integer> iter = person.iterator();
				
				while (iter.hasNext()) {
					Integer rowPerson = iter.next();
					if(castle[i].substring(rowPerson, rowPerson+1).equals("X")) {
						isEmpty = false;
					}
				}
				if(isEmpty) {
					colAdd++;					
				}
			} else {
				colAdd++;
			}
		}
		
		//세로로 체크
		for(int i = 0; i < col; i++) {
			boolean isEmpty = true;
			for(int j = 0; j < row; j++) {
				if(castle[j].substring(i, i+1).equals("X")) {
					isEmpty = false;
				}
			}
			if(isEmpty) {
				rowAdd++;
			}
		}
		
		System.out.println(Math.max(colAdd, rowAdd));
	
	}
}
