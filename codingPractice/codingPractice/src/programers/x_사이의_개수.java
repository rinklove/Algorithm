package programers;

public class x_사이의_개수 {

	public static void main(String[] args) {
		
		String myString = "oxooxoxxox";
		String[] split = myString.split("x", -1);
		
		int[] answer = new int[split.length];
		for(int i =0; i<split.length;i++) {
			answer[i] = split[i].length();
		}
		
	}
}
