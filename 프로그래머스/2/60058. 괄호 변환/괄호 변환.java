import java.util.Stack;

class Solution {
    public String solution(String p) {
        String answer = process(p);
        
        return answer;
    }

    //올바른 괄호 문자열로 변환을 진행하는 함수
    private String process(String brackets) {
        if (brackets.isEmpty())
            return "";

        int index = split(brackets);
        String u = brackets.substring(0, index);
        String v = brackets.substring(index);

        if(isCorrect(u)) {
            //올바른 괄호 문자열인 경우
            return u + process(v);
        } else {
            //올바른 괄호 문자열이 아닌 경우
            return convert(u, v);
        }
    }

    //한개의 균형잡힌 괄호 문자열을 2개의 균형잡힌 괄호 문자열로 나누는 인덱스 반환
    private int split(String bracket) {
        int[] count = new int[2];

        for(int i = 0; i < bracket.length(); i++) {
            char c = bracket.charAt(i);

            if (c == '(') {
                count[0]++;
            } else {
                count[1]++;
            }

            if(count[0] != 0 && count[1] != 0 && count[0] == count[1])
                return i+1;
        }

        return bracket.length();
    }

    //전달받은 괄호 문자열이 올바른 괄호 문자열인지 검사
    private boolean isCorrect(String bracket) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < bracket.length(); i++) {
            char c = bracket.charAt(i);

            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    // 올바른 문자열이 아닐 때, 올바른 괄호로 변환
    private String convert(String bracket1, String bracket2) {
        StringBuilder sb = new StringBuilder();
        bracket1 = bracket1.isEmpty() ? "" : bracket1.substring(1,bracket1.length()-1);
        
        sb.append("(")
                .append(process(bracket2))
                .append(")")
                .append(reverse(bracket1));

        return sb.toString();
    }

    //양 끝을 제거하고 괄호의 방향을 뒤집는 함수
    private String reverse(String bracket) {
        StringBuilder sb = new StringBuilder();
        

        for (int i = 0; i < bracket.length(); i++) {
            if(bracket.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }
}
