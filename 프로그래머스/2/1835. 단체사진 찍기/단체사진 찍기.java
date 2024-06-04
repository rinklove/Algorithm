/*
    dfs + 문자열이 8개가 되었을 때, 조건 값 추가하기
*/
class Solution {
    
    public int solution(int n, String[] data) {
        //dfs로 조건에 부합하는 순서 개수 구하기
        return dfs("", "ACFJMNRT", data);
    }
    
    private int dfs(String characters, String others, String[] data) {
        
        //모든 순서가 나오고 해당 순서가 특정 조건에 부합하면 1을 반환
        if(characters.length() == 8 && satisfy(characters, data)) {
            return 1;
        }
        
        int result = 0; //결과값을 저장하는 변수
        
        //dfs 본격 수행
        for(int i = 0; i < others.length(); i++) {
            String newCharacters = characters + others.charAt(i);
            String newOthers = others.substring(0,i) + others.substring(i+1);
            result += dfs(newCharacters, newOthers, data);
        }
        return result;
    }
    
    //순서 character가 모든 조건들을 만족하는 지 검사하는 메서드
    private boolean satisfy(String character, String[] data) {
        for(String d : data) {
            if(!check(character, d)) {
                return false;
            }
        }
        return true;
    }
    
    //하나의 조건을 검사
    private boolean check(String character, String d) {
        String c1 = d.substring(0,1);   //캐릭터 1
        String c2 = d.substring(2,3);   //캐릭터 2
        char oper = d.charAt(3);        //연산자
        //두 캐릭터간의 거리
        int distance = Math.abs(character.indexOf(c1) - character.indexOf(c2)) - 1;
        //요구 거리
        int required = Integer.parseInt(d.substring(4)); 
        
        boolean condition =  switch(oper) {
            case '=' -> distance == required; 
            case '>' -> distance > required; 
            default -> distance < required; 
        };
        
        return condition;
    }
}