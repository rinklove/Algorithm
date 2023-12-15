package programers;

public class StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 String s = "Zbcdefg";
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

	}

}
