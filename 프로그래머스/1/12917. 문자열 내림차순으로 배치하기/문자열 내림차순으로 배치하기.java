import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr= s.toCharArray();
		char tmp;
		for (int i=0; i< arr.length;i++) {
				for(int j =i; j<arr.length;j++) {
					if(arr[i] < arr[j] ) {
						tmp = arr[j];
						arr[j] = arr[i];
						arr[i] = tmp;
					}
				}
			}
		StringBuffer buffer  = new StringBuffer();
		answer = buffer.append(arr).toString();
        return answer;
    }
}