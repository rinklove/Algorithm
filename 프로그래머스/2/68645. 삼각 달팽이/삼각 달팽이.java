class Solution {
    
    public int number = 1;
    
    public int[] solution(int n) {
        int[] answer = {};
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        
        answer = new int[sum];
        
        //채워 넣을 인덱스
        int index = 0;
        
        //호출 횟수
        int Lcount = 0;
        int Rcount = 0;

        for(int i = 0; i <n; i++) {
            int direction =  i % 3;
            switch (direction) {
                case 0:
                    index = fillLeft(n-i, answer, index, Lcount);
                    Lcount++;
                    break;
                case 1:
                    index = fillBottom(n-i, answer, index);
                    break;
                default:
                    index = fillRight(n-i, answer, index, n-Rcount);
                    Rcount++;
                    break;
            }
        }
        return answer;
    }
    
    //호출 횟수 필요
    private int fillLeft(int n, int[] answer, int index, int count) {
        int next = count;
        for(int i = 0; i < n; i++) {
            index += next+count;
            answer[index] = number++;
            next++;
        }
        System.out.println();
        return index;
    }

    private int fillBottom(int n, int[] answer, int index) {
        for (int i = 0; i < n; i++) {
            index++;
            answer[index] = number++;
        }
        return index;
    }

    private int fillRight(int n, int[] answer, int index, int next) {
        for (int i = 0; i < n; i++) {
            index -= next;
            answer[index] = number++;
            next--;
        }
        return index;
    }
}