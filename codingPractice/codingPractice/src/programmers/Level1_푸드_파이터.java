package programmers;

public class Level1_푸드_파이터 {

    public static void main(String[] args) {

        String solution = solution(new int[]{1, 3, 4, 6});
        System.out.println("solution = " + solution);
    }

    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int index = 1; index < food.length; index++) {

            int count = food[index] / 2;

            for (int c = 0; c < count; c++) {
                sb.append(index);
            }
        }

        String player1 = sb.toString()+"0";
        sb.reverse();
        sb.insert(0, player1);
        return sb.toString();
    }
}
