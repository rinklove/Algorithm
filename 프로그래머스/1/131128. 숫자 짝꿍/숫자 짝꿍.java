class Solution {
    public String solution(String X, String Y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        int[] answerCount = new int[10];
        StringBuilder answer = new StringBuilder();

        String[] splitX = X.split("");
        String[] splitY = Y.split("");

        for (String x : splitX) {
            int i = Integer.parseInt(x);
            xCount[i]++;
        }

        for (String y : splitY) {
            int i = Integer.parseInt(y);
            yCount[i]++;
        }

        for(int i = 0; i < answerCount.length; i++) {
            answerCount[i] = Math.min(xCount[i], yCount[i]);
            System.out.println("answerCount = " + answerCount[i]);
        }

        for(int i = 9; i >= 0; i--) {
            answer.append(String.valueOf(i).repeat(answerCount[i]));
        }
        String str = answer.toString();

        if(str.isEmpty()) return "-1";
        else if(str.replace("0", "").isEmpty()) return "0";
        else return str;
    }
}