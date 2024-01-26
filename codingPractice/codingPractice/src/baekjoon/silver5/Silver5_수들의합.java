package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver5_수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//시간 초과
		long num = Long.parseLong(br.readLine());
		long count = 0;
		long currentSum = 0;
		while(true) {
			currentSum = count* (count + 1) / 2;
			if(currentSum < num)
				count++;
			else break;
		}
		System.out.println("currentSum = " + currentSum);
		count = num <=  2 ? 1 : currentSum == num ? count : count-1;
		bw.write(String.valueOf(count));
		bw.flush();
		
	}
}
