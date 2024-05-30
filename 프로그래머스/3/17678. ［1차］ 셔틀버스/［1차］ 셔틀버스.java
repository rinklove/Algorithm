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
        int end = 60*24;
        
        //크루 대기열 형성
        wait(timetable);
        
        //셔틀 도착하는 시간에 맞춰서 탑승
        while(true) {
            seats = rideShuttle(seats, m, start);
            count++;
            if(count == n) break;
            start += t;
        } 
        
        // for(int i : seats) {
        //     System.out.println(i);
        // }
        int con = getConTime(seats, start);
        
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
        if(min == 0) con = start;
        // else if(min == max && min != 0) con = max-1;
        else con = max-1;
        
        return con;
    }
    
    private int[] rideShuttle(int[] seats, int m, int time) {
        Arrays.fill(seats, 0); //셔틀 초기화
        int index = 0;
        
        while(!queue.isEmpty() && index < m) {
            if(queue.peek() <= time) {
                seats[index++] = queue.poll();
            } else break;
        }
        
        return seats;
    }
    
    private void wait(String[] timetable) {
        Arrays.sort(timetable);
        
        for(String t :timetable) {
            int minutes = getMinutes(t);
            queue.offer(minutes);
        }
    }
    
    //시각을 분으로
    private int getMinutes(String time) {
        String[] split = time.split(":");
        
        return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
    }
    
    //분을 시각으로
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