class Solution {
    public String solution(int[] food) {
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