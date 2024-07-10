import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private final int CLEANING_TIME = 10;
    public int solution(String[][] book_time) {
        int[][] times = getReserveTime(book_time);
        List<List<int[]>> rooms = new ArrayList<>();
        //각 예약 시간마다 적절한 방을 배정해준다.
        for(int[] time: times) {
            reserve(rooms, time);
        }
        //예약된 방의 개수를 반환한다.
        return rooms.size();
    }
    
    //예약하는 메서드
    private void reserve(List<List<int[]>> rooms, int[] time) {
        //각 방마다 예약이 가능한 방이 있는 지 확인하여 예약한다.
        for(List<int[]> room : rooms) {
            //예약이 가능하다면 해당 방에 예약을 하고 종료
            if(canReserve(room, time)) {
                room.add(time);
                return;
            }
        }
        //예약이 가능한 방이 없다면 새로운 방에 예약
        reserveNew(rooms, time);
    }
    
    private boolean canReserve(List<int[]> room, int[] time) {
        for(int[] reserve : room) {
            if(time[0] >= reserve[0] && time[0] < reserve[1] ||
               time[1] >= reserve[0] && time[1] < reserve[1]) {
                return false;
            }
        }
        return true;
    }
    
    private void reserveNew(List<List<int[]>> rooms, int[] time) {
        List<int[]> newRoom = new ArrayList<>();
        newRoom.add(time);
        rooms.add(newRoom);
    }
    
    private int[][] getReserveTime(String[][] times) {
        int[][] reserveTime = new int[times.length][2];
        for(int i = 0; i < reserveTime.length; i++) {
            reserveTime[i][0] = getTime(times[i][0]);
            reserveTime[i][1] = getTime(times[i][1]) + CLEANING_TIME;    
        }
        
        //예약 시간 순으로 정렬한다. 만약 시작시간이 같은 경우 종료 시간이 더 긴 예약을 우선으로 예약한다. 
        Arrays.sort(reserveTime, (r1, r2) -> r1[0] == r2[0] ? r2[1] - r2[0] : r1[0] - r2[0]);
        return reserveTime;
    }
    
    private int getTime(String time) {
        int hours = Integer.parseInt(time.substring(0, 2))*60;
        int minutes = Integer.parseInt(time.substring(3));
        return hours + minutes;
    }
}