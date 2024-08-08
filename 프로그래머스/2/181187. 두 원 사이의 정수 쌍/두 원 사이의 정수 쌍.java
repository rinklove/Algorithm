class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long area1 = (long)r1*r1; 
        long area2 = (long)r2*r2;
        for(int i = 0; i <= r2; i++) {
            long outerX = (long) Math.floor(Math.sqrt(area2 - Math.pow (i,2)));
            long innerX = (long) Math.ceil(Math.max(0, Math.sqrt(area1 - Math.pow (i,2))));

            answer += outerX - innerX + 1;
        }
        
        return (answer - (r2-r1+1))*4;
    }
}