//주말 
class Solution {
    private static final int WEEK = 7;
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int s = 0; s < schedules.length; s++) {
            int count = 0;
            int today = startday;
            for(int current = 0; current < WEEK; current++) {
                System.out.println("today = " + today);
                if(isWeekdays(today)) {
                    count += checkCondition(schedules[s], timelogs[s][current]);
                }
                
                today = getNextDay(today);
            }
            
            if(isParticipatedEvent(count)) answer++;
        }
        
        return answer;
    }
    
    private int checkCondition(int schedule, int timeLog) {
        int time = getTime(timeLog);
        int condition = getTime(schedule);
        
        return time <= condition + 10 ? 1 : 0;
    }
    
    private int getNextDay(int today) {
        return (today % WEEK) + 1;
    }
    
    private int getHour(int timeLog) {
        return timeLog / 100;
    }
    
    private int getMinute(int timeLog) {
        return timeLog % 100;
    }
    
    private int getTime(int timeLog) {
        return getHour(timeLog) * 60 + getMinute(timeLog);
    }
    
    private boolean isWeekdays(int today) {
        return today < 6;
    }
    
    private boolean isParticipatedEvent(int count) {
        return count == 5;
    }
}