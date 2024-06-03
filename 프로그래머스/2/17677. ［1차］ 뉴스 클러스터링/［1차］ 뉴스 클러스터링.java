import java.util.List;
import java.util.ArrayList;

class Solution {
    private final List<String> listA = new ArrayList<>();
    private final List<String> listB = new ArrayList<>();
    public int solution(String str1, String str2) {
        //원문 가공
        str1 = convert(str1);
        str2 = convert(str2);
        
        //A, B의 다중원소 설정
        setElement(str1, str2);
        
        //자카드 유사도 * 65536 값 구하기
        return findJacard();
    }
    
    private int findJacard() {
        float union = 0;        //합집합
        float intersect = 0;    //교집합
        
        int sizeA = listA.size();
        for(int i = 0; i < sizeA; i++) {
            String find = listA.remove(0);
            union++;
            if(listB.remove(find)) {
                intersect++;
            }
            // System.out.print("find = " + find);
            // System.out.print(", union = " + union);
            // System.out.println(", intersect = " + intersect);
        }
        
        union += listA.size() + listB.size();
        
        //공집합끼리 비교하는 경우 항상 일치하므로 자카드 유사도는 1이 됨.
        return union == 0 ? 65536 : (int) (65536 * intersect / union);
    }
    
    private void setElement(String str1, String str2) {
        for(int i = 0; i < str1.length()-1; i++) {
            String substr = str1.substring(i, i+2);
            if(!substr.contains(" ")) {
                listA.add(substr);            
            }
        }
        
        for(int i = 0; i < str2.length()-1; i++) {
            String substr = str2.substring(i, i+2);
            //문자로만 이루어진 다중원소를 추가
            if(!substr.contains(" ")) {
                listB.add(substr);            
            }
        }
    }
    
    private String convert(String str) {
        //특수문자를 공백으로 치환한다.
        return str.toLowerCase().replaceAll("[^a-z]", " ");
    }
}