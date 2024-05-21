class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w=0;
        int h=0;
        for(int i=0; i < sizes.length; i++) {
            int mid_w = Math.max(sizes[i][0], sizes[i][1]);
            int mid_h = Math.min(sizes[i][0], sizes[i][1]);
            w = Math.max(w, mid_w);
            h = Math.max(h, mid_h);
        }
    
        answer = w * h;
        return answer;
    }
}