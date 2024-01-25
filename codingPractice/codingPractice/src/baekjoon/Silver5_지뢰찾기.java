package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver5_지뢰찾기 {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());

		char[][] mineMap = new char[size][size];

		for(int i = 0; i < mineMap.length; i++) {
			mineMap[i] = br.readLine().toCharArray();
		}

		char[][] searchMap = new char[size][size];


		//맵을 1차 세팅
		for(int line = 0; line < size; line++) {
			for (int index = 0; index < size; index++) {
				if(mineMap[line][index] != '.') {
					searchMap[line][index] = '*';
				} else {
					int count = searchMine(mineMap, line, index);

					if(count >= 10) {
						searchMap[line][index] = 'M';
					} else {
						searchMap[line][index] = (char) (count + 48);
					}
				}
			}
		}


		StringBuilder sb = new StringBuilder();

		for(char[] c : searchMap) {
			for (char per : c) {
				sb.append(per);
			}
			System.out.println("sb = " + sb.toString());
			sb.setLength(0);
		}
	}

	private static int searchMine(char[][] mineMap, int line, int index) {
		int mineMapLength = mineMap.length;
		int mineMapWidth = mineMap[0].length;
		int total = 0;

		for(int dLine = -1; dLine <= 1; dLine++) {
			for(int dIndex = -1; dIndex <= 1; dIndex++) {
				int newLine = line + dLine;
				int newIndex = index + dIndex;

				if(isValid(newLine, newIndex, mineMapLength, mineMapWidth) && Character.isDigit(mineMap[newLine][newIndex])) {
					total += Character.getNumericValue(mineMap[newLine][newIndex]);
				}
			}
		}

		return total;
	}


	private static boolean isValid(int line, int index, int newLine, int newIndex) {
		return line >= 0 && newLine > line && index >= 0 && newIndex > index;
	}

}
