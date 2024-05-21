class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        	int num1 = 0;
		int num2 = 0;

		for (int i = bin1.length(); i > 0; i--) {
			num1 += Math.pow(2, i - 1) * Integer.parseInt(bin1.substring(bin1.length() - i, bin1.length() - i + 1));
		}

		for (int i = bin2.length(); i > 0; i--) {
			num2 += Math.pow(2, i - 1) * Integer.parseInt(bin2.substring(bin2.length() - i, bin2.length() - i + 1));
		}
		
		answer = Integer.toBinaryString(num1+num2);
        return answer;
    }
}