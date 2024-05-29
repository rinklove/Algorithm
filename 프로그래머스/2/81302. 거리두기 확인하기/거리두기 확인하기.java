class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int index = 0;
        
        for(String[] place : places) {
            if(isFollowed(place)) {
                answer[index] = 1;
            }
            index++;
        }
        return answer;
    }
    
    private boolean isFollowed(String[] place) {
        for(int i = 0; i < place.length; i++) {
            for(int j = 0; j < place[i].length(); j++) {
                char c = place[i].charAt(j);
                if(c != 'X' && checkPerson(place, i, j, c)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkPerson(String[] place, int i, int j, char c) {
        return findP(place, i, j, c);
    }
    
    private boolean findP(String[] place, int i, int j, char c) {
        int count = 0;
        if(i-1 >= 0) {
            if(place[i-1].charAt(j) == 'P') count++;
        }
        
        if(i+1 < place.length) {
            if(place[i+1].charAt(j) == 'P') count++;
        }
        
        if(j-1 >= 0) {
            if(place[i].charAt(j-1) == 'P') count++;
        }
        
        if(j+1 < place[i].length()) {
            if(place[i].charAt(j+1) == 'P') count++;
        }
        
        return (c == 'O' && count > 1) || (c == 'P' && count > 0);
    }
}