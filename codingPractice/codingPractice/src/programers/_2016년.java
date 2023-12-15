package programers;

import java.time.LocalDate;

public class _2016년 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate date = LocalDate.of(2016, 5, 24);
		String str = date.getDayOfWeek().name().substring(0,3);
		System.out.println(str);
		
	}

}
