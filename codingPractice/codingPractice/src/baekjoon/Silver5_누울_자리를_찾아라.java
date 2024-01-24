package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Silver5_누울_자리를_찾아라 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int N = br.read();
			String[] room  = new String[N];
			
			int ableRow = 0;
			String[] current = {};
			for(int i = 0; i < N; i ++) {
				room[i] = br.readLine();
				current = room[i].split("X");
				ableRow += Arrays.stream(current).filter(c -> c.contains("..")).count();
			}
			int ableCol = 0;
			
			for(int i = 0; i <N ; i++) {
				int index = i;
				current = Arrays.stream(room).flatMap(s -> s.lines().map(el -> el.substring(index, index+1))).collect(Collectors.joining("")).split("X");
				ableCol += Arrays.stream(current).filter(c -> c.contains("..")).count();
			}
			
			bw.write(ableRow + " " + ableCol);
			bw.flush();
		
	}
}
