class Solution {
    public String solution(String phone_number) {
        String change_number = phone_number.substring(0, phone_number.length()-4);
        String star_number = "";
        for(int i = 0;i<change_number.length();i++) {
            star_number += "*";
        }
        String answer = star_number + phone_number.substring(phone_number.length()-4, 
                                                            phone_number.length());
        return answer;
    }
}