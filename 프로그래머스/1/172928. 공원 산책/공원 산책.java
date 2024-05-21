class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
		 
 		for(int i =0; i< park.length; i++) {
 			if(park[i].contains("S")) {
 				answer[0] = i;
 				answer[1] = park[i].indexOf("S");
 			}
		}
 		
		for(int j = 0; j < routes.length; j++) {
			String[] split = routes[j].split(" ");
			
			int tmpY = answer[0]; //깊이
			int tmpX = answer[1]; //넓이
			
			int moves = Integer.parseInt(split[1]);
			
			switch (split[0]) {
				case "W": tmpX -= moves; break;
				case "S": tmpY += moves; break;
				case "N": tmpY -= moves; break;
				default: tmpX += moves; break;
			}
			
			if(tmpX >= park[0].length() || tmpY >= park.length || tmpX < 0 || tmpY < 0) continue;
			
			boolean obstacle = false;
			if(tmpX != answer[1]) {
				for(int road = Math.min(tmpX, answer[1]); road <= Math.max(tmpX, answer[1]); road++) {
					if((park[tmpY].charAt(road)+"").equals("X")) {
						obstacle = true;
						break;
					}
				}
			} else {
				for(int road = Math.min(tmpY, answer[0]); road <= Math.max(tmpY, answer[0]); road++) {
					if((park[road].charAt(tmpX)+"").equals("X")) {
						obstacle = true;
						break;
					}
				}
			}
			
			if(!obstacle) {
				answer[0] = tmpY;
				answer[1] = tmpX;
			}
		}
        return answer;
    }
}