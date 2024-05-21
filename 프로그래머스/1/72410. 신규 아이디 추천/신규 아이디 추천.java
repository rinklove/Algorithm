class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
		
		//2단계(45 ~ 46 48 ~57, 95, 97~122)
		new_id = new_id.replaceAll("[^a-z0-9._-]", "");
		
		//3단계
		while(new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}
		
		//4단계
		if(new_id.startsWith(".")) new_id = new_id.substring(1);
		if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);

		//5단계
		if(new_id.equals("")) new_id = "a";
		
		//6단계
		if(new_id.length() > 15) new_id = new_id.substring(0, 15);
		if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
		
		//7단계
		if(new_id.length() < 3) {
			for(int i = new_id.length(); i < 3; i++) {
				new_id = new_id.concat(new_id.charAt(i-1)+"");
			}
		}
        return new_id;
    }
}