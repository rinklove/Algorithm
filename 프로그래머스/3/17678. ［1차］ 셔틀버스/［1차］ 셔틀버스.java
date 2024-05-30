import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private final Queue<Integer> queue = new LinkedList<>();
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] seats = new int[m];
        int count = 0;
        int start = 60*9;
        
        //크루 대기열 형성
        wait(timetable);
        
        //셔틀 도착하는 시간에 맞춰서 탑승
        while(true) {
            seats = rideShuttle(seats, m, start);
            count++;
            if(count == n) break;
            start += t;
        } 
        
        //콘이 도착할 수 있는 가장 늦은 시간을 구한다
        int con = getConTime(seats, start);
        queue.clear();
        return getTime(con);
    }
    
    private int getConTime(int[] seats, int start) {
        int con = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < seats.length; i++) {
            min = Math.min(min, seats[i]);
            max = Math.max(max, seats[i]);
        }
        
        if(min == 0) con = start;   //만약 빈자리가 있으면 셔틀 도착시간에 맞춰서 온다.
        else con = max-1;   //빈자리가 없으면, 가장 늦게 도착한 사람보다 1분 먼저 도착한다.
        
        return con;
    }
    
    private int[] rideShuttle(int[] seats, int m, int time) {
        Arrays.fill(seats, 0); //셔틀 좌석 초기화
        int index = 0;
        
        while(!queue.isEmpty() && index < m) {
            if(queue.peek() <= time) {
                seats[index++] = queue.poll();
            } else break;
        }
        
        return seats;
    }
    
    //크루 도착시간에 맞게 정렬 후 셔틀 대기줄에서 대기
    private void wait(String[] timetable) {
        Arrays.sort(timetable);
        
        for(String t :timetable) {
            int minutes = getMinutes(t);
            queue.offer(minutes);
        }
    }
    
    //"HH:MM"을 분으로 표현(String -> int)
    private int getMinutes(String time) {
        String[] split = time.split(":");
        
        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }
    
    //분을 "HH:MM"으로 표현(int -> String)
    private String getTime(int minutes) {
        StringBuilder sb = new StringBuilder();
        
        if(minutes / 60 < 10) {
            sb.append("0");
        }
        sb.append(minutes / 60).append(":");
        
        if(minutes % 60 < 10) {
            sb.append("0");
        } 
        sb.append(minutes % 60);
        
        return sb.toString();
    }
}