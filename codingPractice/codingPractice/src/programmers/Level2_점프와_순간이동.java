package programmers;

public class Level2_점프와_순간이동 {

    /**
     * 도착한 위치에서부터 0까지 시작?
     * @param args
     */
    public static void main(String[] args) {

        int answer = solution(5000);
        System.out.println("answer = " + answer);
    }

    public static int solution(int n) {
        int ans = 0;

        while(n != 0) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}
