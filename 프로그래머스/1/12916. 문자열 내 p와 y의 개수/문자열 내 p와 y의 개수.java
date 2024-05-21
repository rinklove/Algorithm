class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        String[] strArray = s.toLowerCase().split("");
        int pCount = 0;
        int yCount = 0;
        
        for(int i = 0; i < strArray.length; i++) {
            if(strArray[i].equals("p")) pCount++;
            if(strArray[i].equals("y")) yCount++;
        }
        
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return pCount == yCount? true : false;
    }
}