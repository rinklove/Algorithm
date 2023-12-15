package programers;

public class ChangeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5 2 5 7 1 -> 7 5 5 2 1
		int n =1;
		int[] num_list = {2,1,6};
		int length = num_list.length;
		int tmp;
		int[] arr = new int[num_list.length];

		for(int i = n; i<length; i++) {
			arr[i-n] = num_list[i];
		}
		
		for(int i =1; i < n; i++) {
			arr[i+n-1] = num_list[i];
		}
		
		arr[n-1] = num_list[0];
		for(int i :arr) {
			System.out.println(i);
		}
		System.out.println();
//		if(n != 1) {
//			tmp = num_list[n-1];
//			num_list[n-1] = num_list[length-1];
//			num_list[length-1] = tmp;
//		}
	}
}
