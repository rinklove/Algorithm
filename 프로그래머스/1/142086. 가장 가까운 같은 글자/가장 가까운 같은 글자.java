class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
		
		String[] arr = s.split("");
		answer[0] = -1;
		for(int i =1 ;i< arr.length;i++) {
			String front = s.substring(0, i);
			
			answer[i] = front.lastIndexOf(arr[i]) == -1? front.lastIndexOf(arr[i]) : i -front.lastIndexOf(arr[i]);
		}
        return answer;
    }
}