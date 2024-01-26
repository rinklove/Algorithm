package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver5_문서검색 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine(); //한줄에 입력받기
		String replace = br.readLine();
		int count = 0;
//		bw.write(str); //str값 출력
//		bw.flush(); //남은값 모두 출력 하면서 비우기
		
		
		while(str.contains(replace)) {
			str = str.replaceFirst(replace, "/");
			count++;
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
