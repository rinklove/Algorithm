import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    
    private final String come = "님이 들어왔습니다.";
    private final String out = "님이 나갔습니다.";
    private final Map<String, String> userInfoMap = new HashMap<>();
    private final List<StringBuilder> logList = new ArrayList<>();
    
    public String[] solution(String[] record) {
        String[] answer = {};
        StringBuilder log = null;
        
        for(String r : record) {
            String[] per = r.split(" ");
            
            log = handleUser(per);
            addLog(log);
        }
        
        answer = new String[logList.size()];
        
        for(int i = 0; i < logList.size(); i++) {
            StringBuilder curr = logList.get(i);
            int index = curr.indexOf("님");
            String uid = curr.substring(0, index);
            
            curr.replace(0, index, userInfoMap.get(uid));
            
            answer[i] = curr.toString();
        }
        
        return answer;
    }
    
    
    private StringBuilder handleUser(String[] per) {
        StringBuilder sb = new StringBuilder();
        switch(per[0]) {
            case "Enter":
                userInfoMap.put(per[1], per[2]);
                sb.append(per[1]).append(come);
                break;
            case "Leave":
                sb.append(per[1]).append(out);
                break;
            default: 
                userInfoMap.put(per[1], per[2]);
                return null;
        }
        
        return sb;
    }
    
    private void addLog(StringBuilder log) {
        if(log != null) {
            logList.add(log);
        }
    }
}