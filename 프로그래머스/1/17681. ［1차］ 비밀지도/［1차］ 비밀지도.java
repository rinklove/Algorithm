import java.util.ArrayList;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i<arr1.length; i++) {
			answer[i] = "";
			for(int j = 0; j<n; j++) {
				if(arr1[i] % 2 == 0 && arr2[i] % 2 ==0) list.add(" ");
				else list.add("#");
				arr1[i] /=2;
				arr2[i] /=2;				
			}
			for(int k =0; k<list.size();k++) {
				answer[i] += list.get(list.size()-1-k);
			}
			list.clear();
		}
        return answer;
    }
}