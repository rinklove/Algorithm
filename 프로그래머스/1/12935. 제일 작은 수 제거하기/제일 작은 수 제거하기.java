import java.util.ArrayList;


class Solution {
    public int[] solution(int[] arr) {
        int[] answer=arr;
		int[] newArr = new int[answer.length-1];
		int index = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		if(answer.length == 1) {
			return new int[] {-1};	
		}else {
			for(int i = 0 ;i <arr.length; i++) {
				list.add(arr[i]);
				if(arr[index] > arr[i]) {
					index = i;
				}
			}
		}
		list.remove(index);
		
		for(int i =0;i<list.size();i++) {
			newArr[i] = list.get(i);
		}

        return newArr;
    }
}