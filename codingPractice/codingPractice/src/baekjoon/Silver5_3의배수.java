package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Silver5_3의배수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String num = br.readLine();
		int count = 0;
		
		while(num.length() > 1) {
			num = String.valueOf(num.chars().map(c -> c-48).sum());
			count++;
		}
		
		bw.write(String.valueOf(count));
		bw.newLine();
		if(Integer.parseInt(num) % 3 == 0) {
			bw.write("YES");
		} else {
			bw.write("NO");
		}
		bw.flush();
	}
}
