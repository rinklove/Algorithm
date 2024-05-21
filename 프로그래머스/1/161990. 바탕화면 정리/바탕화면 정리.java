// 1. [위, 왼쪽, 오른쪽, 아래]를 지정하면 된다.
// 2. 위와 왼쪽은 최소값을 구해야 하고 오른쪽과 아래는 최댓값을 구해야 한다. 
// 3. 0,0 에 파일이 존재한다면 위, 왼쪽은 [0, 0]이고 오른쪽, 아래 1씩 더한 값 [1, 1]이다.	

class Solution {
    public int[] solution(String[] wallpaper) {
        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    top = Math.min(i, top);
                    left = Math.min(j, left);
                    bottom = Math.max(i + 1, bottom);
                    right = Math.max(j + 1, right);
                }
            }
        }
        
        return new int[]{top, left, bottom, right};
    }
}