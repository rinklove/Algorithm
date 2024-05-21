import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

class Solution {
    /*
            * + -
            * - +
            + * -
            + - *
            - * +
            - + *
    */
    public long solution(String expression) {
        long answer = 0;
        
        //우선 순위가 되는 모든 경우의 수를 담는 배열
        String[][] priorities = new String[6][]; 
        priorities[0] = new String[]{"*", "+", "-"};
        priorities[1] = new String[]{"*", "-", "+"};
        priorities[2] = new String[]{"+", "*", "-"};
        priorities[3] = new String[]{"+", "-", "*"};
        priorities[4] = new String[]{"-", "*", "+"};
        priorities[5] = new String[]{"-", "+", "*"};
        
        //연산자와 수식 분리
        String[] numArr = expression.split("[-+*]");
        String[] operArr = expression.replaceAll("[0-9]","").split("");
        
        ArrayList<Long> numbers = null;
        
        ArrayList<String> opers = null;
            
            
            for(String[] p : priorities) {
                long tmp = 0;
            numbers = (ArrayList<Long>) Arrays.stream(numArr).map(Long::parseLong).collect(Collectors.toList());
            opers = (ArrayList<String>)new ArrayList(List.of(operArr));
                for(String per : p) {
                    while(opers.contains(per)) {
                        int index = opers.indexOf(per);
                        String current = opers.remove(index);

                        long num1 = numbers.remove(index);
                        long num2 = numbers.remove(index);

                        tmp = switch(current) {
                                case "+" -> num1 + num2; 
                                case "-" -> num1 - num2; 
                                default -> num1 * num2;
                        };
                        
                        numbers.add(index, tmp);
                    }
                }    
                
                long result = Math.abs(tmp);
                if(result > answer) answer = result;
            }
            
        return answer;
    }
}