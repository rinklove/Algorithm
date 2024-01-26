package baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Silver5_경매 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int U = sc.nextInt();
		int N = sc.nextInt();

		List<Ouctry> list = new ArrayList<>();
		
		for(int i =0; i < N; i++) {
			list.add(new Ouctry(sc.next(), sc.nextInt()));
		}
		sc.close();
		
		List<Ouctry> collect = list.stream().filter(i -> i.price <= U) .sorted((i1, i2) -> i1.price - i2.price).collect(Collectors.toList());
		
		int min = collect.get(0).price;
//		이 부분 로직 다시 짜는 게 나을 듯
//		int count = (int) list.stream().filter(e-> e.price == min).count();
//		Ouctry ouctry = null;
//		if(count > 1) {
//			if(collect.stream().filter(i -> i.price != min).distinct().count() != collect.stream().distinct().count()) {
//				ouctry = collect.stream().filter(i -> i.price != min).findFirst().orElse(list.get(0));
//			}
//		} else {
//			ouctry = collect.get(0);
//		}
//		System.out.println(ouctry.name +  " " + ouctry.price);
	}
	
	
	static class Ouctry{
		private String name;
		private int price;
		
		public Ouctry(String name, int price) {
			this.name = name;
			this.price = price;
		}
		
	}

}
