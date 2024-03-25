package programmers.kakao;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Level2_주차_요금_계산 {

    public static void main(String[] args) {

        int[] solution = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        for (int index : solution) {
            System.out.println("index = " + index);
        }
    }

    public static int[] solution(int[] fees, String[] records) {

        //주차 시간 map
        Map<String, LocalTime> timeMap = new HashMap<>();
        //요금 map
        Map<String, Integer> feeMap = new HashMap<>();

        //주차 기록 저장
        for (String record : records) {
            String[] log = record.split(" ");
            LocalTime time = LocalTime.parse(log[0], DateTimeFormatter.ofPattern("H:m"));

            if(log[2].equals("IN")) {
                timeMap.put(log[1], time);
            } else {
                LocalTime in = timeMap.get(log[1]);
                int parkingTime = getParkingTime(time, in);
                feeMap.put(log[1], feeMap.getOrDefault(log[1], 0)+parkingTime);
                timeMap.remove(log[1]);
            }
        }

        //남아 있는 주차 기록 처리
        for (Map.Entry<String, LocalTime> next : timeMap.entrySet()) {
            LocalTime end = LocalTime.of(23, 59);
            String key = next.getKey();
            LocalTime in = next.getValue();
            int parkingTime = getParkingTime(end, in);

            feeMap.put(key, feeMap.getOrDefault(key, 0) + parkingTime);
        }

        //주차 시간에 따라 요금 부과
        int[] answer = feeMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .mapToInt(i -> {
                    i -= fees[0];
                    int fee = fees[1];
                    if(i > 0) {
                        if(i % fees[2] != 0) {
                            i += fees[2];
                        }
                        i /= fees[2];
                        fee += i * fees[3];
                    }
                    return fee;
                }).toArray();

        return answer;
    }

    /**
     * 주차 시간 구하는 메서드
     * @param time
     * @param in
     * @return
     */
    private static int getParkingTime(LocalTime time, LocalTime in) {
        time = time.minusHours(in.getHour());
        time = time.minusMinutes(in.getMinute());

        return time.getHour() * 60 + time.getMinute();
    }
}
