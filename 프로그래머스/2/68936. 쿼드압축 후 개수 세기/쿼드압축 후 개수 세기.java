/*
    크기가 큰 배열부터 압축.
    압축 후 압축했다는 플래그 설정
    7 9 -> 4 9 
*/
class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0,0};
        for(int[] a : arr) {
            for(int n : a) {
                answer[n]++;
            }
        }
        return compress(arr, answer);
    }
    
    private int[] compress(int[][] arr, int[] answer) {
        int length = arr.length;
        boolean[][] compressed = new boolean[length][length];
        
        while(length > 1) {
            for(int i  = 0; i < arr.length; i += length) {
                for(int j = 0; j < arr.length; j += length) {
                    //압축 되지 않았다면 해당 영역을 탐색.
                    if(!compressed[i][j]) {
                        //1개수 구하기
                        int count = countOne(arr, i, j, length);
                        setCount(length, count, answer, compressed, i, j);
                    }
                }
            }
            length /= 2;
        }
        return answer;
    }
    
    private int countOne(int[][] arr, int i, int j, int length) {
        int count = 0;
        for(int x = i; x < i+length; x++) {
            for(int y = j; y < j+length; y++) {
                if(arr[x][y] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private void setCount(int length, int count, int[] arr, boolean[][] flag, int i, int j) {
        //탐색한 영역이 모두다 0또는 1로 되어있다면 압축 후 플래그 설정
        int total = length*length;
        if(count == total) {
            arr[1] += (1-total);
            setFlag(flag, i, j, length);
        } else if(count == 0) {
            arr[0] += (1-total);
            setFlag(flag, i, j, length);
        }
    }
    
    private void setFlag(boolean[][] flag, int i, int j, int length) {
        for(int x = i; x < i+length; x++) {
            for(int y = j; y < j+length; y++) {
                flag[x][y] = true;
            }
        }
    }
}