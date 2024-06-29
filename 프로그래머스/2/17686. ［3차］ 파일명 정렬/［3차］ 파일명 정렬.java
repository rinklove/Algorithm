/*
    1. 파일을 head, number, tail로 구분하기.
    2. 정렬 기준에 맞추어서 정렬하기
        head, number 일치시 사전순으로 정렬 -> Arrays.sort() 사용
*/
import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (s1, s2) -> {
            //파일명을 head, number, tail로 구분
            String[] split1 = split(s1);
            String[] split2 = split(s2);
            
            // head 비교
            int headCompare = split1[0].compareTo(split2[0]);
            if (headCompare != 0) {
                return headCompare;
            }
            
            // number 비교
            int n1 = Integer.parseInt(split1[1]);
            int n2 = Integer.parseInt(split2[1]);
            return Integer.compare(n1, n2);
        });
        
        return files;
    }
    
    private String[] split(String file) {
        int h = 0;
        while(h < file.length() && !Character.isDigit(file.charAt(h))) {
            h++;
        }
        
        int n = h;
        while(n < file.length() && Character.isDigit(file.charAt(n))) {
            n++;
        }
        
        String head = file.substring(0, h).toLowerCase();
        String number = file.substring(h, n);
        String tail = file.substring(n);
        
        return new String[]{head, number, tail};
    }
}