import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for(int index = 1; index < phone_book.length; index++) {
            if(phone_book[index].startsWith(phone_book[index-1])) {
                return false;
            }
        }
        return true;
    }
}