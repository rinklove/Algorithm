class Solution {
    public boolean solution(int x) {
        
        int dividing = 0;
        String[] strArray = String.valueOf(x).split("");//n.toString().split("");
        
        for( int i = 0; i<strArray.length; i++) {
            dividing += Integer.parseInt(strArray[i]);
        }
        
        return x % dividing == 0? true : false;
    }
}