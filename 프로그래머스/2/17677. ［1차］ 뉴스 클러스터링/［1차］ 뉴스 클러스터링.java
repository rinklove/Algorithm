/*
    합집합 - set
    교집합 - 
*/
import java.util.List;
import java.util.ArrayList;

class Solution {
    private final List<String> listA = new ArrayList<>();
    private final List<String> listB = new ArrayList<>();
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = convert(str1);
        str2 = convert(str2);
        
        setElement(str1, str2);
        
        answer = findJacard();
        
        return answer;
    }
    
    private int findJacard() {
        float union = 0;
        float intersect = 0;
        
        int sizeA = listA.size();
        for(int i = 0; i < sizeA; i++) {
            String find = listA.remove(0);
            union++;
            if(listB.remove(find)) {
                intersect++;
            }
            System.out.print("find = " + find);
            System.out.print(", union = " + union);
            System.out.println(", intersect = " + intersect);
        }
        
        union += listA.size() + listB.size();
        
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
            if(!substr.contains(" ")) {
                listB.add(substr);            
            }
        }
    }
    
    private String convert(String str) {
        return str.toLowerCase().replaceAll("[^a-z]", " ");
    }
}