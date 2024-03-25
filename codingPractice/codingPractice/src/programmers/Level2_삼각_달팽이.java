package programmers;

public class Level2_삼각_달팽이 {

    public static int number = 1;
    /**
     * 정수 n이 매개변수로 주어집니다.
     * 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
     * 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
     * ---
     * 0 -> 6 -> 9 -> 2
     * 0 -> 15 -> 20 -> 2 -> 11
     * ---
     * 내가 왜 직각 삼각형을 생각하지 못했을까..
     * @param args
     */
    public static void main(String[] args) {

        int[] solution = solution(6);
        for (int index : solution) {
            System.out.println("index = " + index);
        }
    }

    public static int[] solution(int n) {
        int[] answer = {};
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        answer = new int[sum];
        //
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
    private static int fillLeft(int n, int[] answer, int index, int count) {
        int next = count;
        for(int i = 0; i < n; i++) {
            index += next+count;
            answer[index] = number++;
            next++;
        }
        System.out.println();
        return index;
    }

    private static int fillBottom(int n, int[] answer, int index) {
        for (int i = 0; i < n; i++) {
            index++;
            answer[index] = number++;
        }
        return index;
    }

    private static int fillRight(int n, int[] answer, int index, int next) {
        for (int i = 0; i < n; i++) {
            index -= next;
            answer[index] = number++;
            next--;
        }
        return index;
    }
}

/*
0
0 ~ 3
0 -> 0 0
1 -> 1 0
2 -> 2 0
3 -> 3 0

1
1 ~ 3
1 -> 3 1
2 -> 3 2
3 -> 3 3

2
2 ~ 3
2 -> 2 2
3 -> 1 1

3
3 ~ 3
3 -> 2 1
 */
