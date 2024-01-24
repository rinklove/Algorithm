package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver5_수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long num = Long.parseLong(br.readLine());
		int count = 0;
		while((count* (count + 1) / 2) < num) {
			count++;
		}
		
		bw.write(String.valueOf(count-1));
		bw.flush();
		
	}
}
