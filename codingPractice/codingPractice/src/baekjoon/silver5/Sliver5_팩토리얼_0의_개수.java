package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Sliver5_팩토리얼_0의_개수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//0의 개수 => 2*5의 개수
		// 5의 개수가 더 적음
		
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		while (num >= 5) {
			count = count + num / 5;
			num = num / 5;
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}
