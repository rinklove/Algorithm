//package programmers.kakao;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//public class 가장_많이_받은_선물 {
//
//    /**
//     * A B: A가 B에게 선물을 줌
//     * 선물 지수 비교 후
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
//
//        solution(new String[]{"muzi", "ryan", "frodo", "neo"},
//                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"});
//    }
//
//    public static int solution(String[] friends, String[] gifts) {
//        int answer = 0;
//
//        //준 횟수
//        Map<String, Integer> sendGiftLog = new HashMap<>();
//        //받은 횟수
//        Map<String, Integer> recvGiftLog = new HashMap<>();
//        //받을 선물 횟수
//        Map<String, Integer> giftScoreMap = new HashMap<>();
//        //선물 받는 횟수
//        Map<String, Integer> haveToRecv = new HashMap<>();
//
//
//
//        for (String p :
//                friends) {
//            sendGiftLog.put(p, 0);
//            recvGiftLog.put(p, 0);
//            haveToRecv.put(p, 0);
//        }
//
//        for (String log :
//                gifts) {
//            String[] s = log.split(" ");
//            sendGiftLog.put(s[0], sendGiftLog.get(s[0]) + 1);
//            recvGiftLog.put(s[1], recvGiftLog.get(s[1]) + 1);
//        }
//
//        //
//        for(String p : friends) {
//            int giftScore = 0;
//            String[][] eachOther = Arrays.stream(gifts).filter(i -> i.contains(p)).map(i -> i.split(" ")).toArray(String[][]::new);
//
//            for(String[] each : eachOther) {
//                if(each[0].equals(p)) {
//                    giftScore++;
//                } else {
//                    giftScore--;
//                }
//            }
//
//            giftScoreMap.put(p, giftScore);
//        }
//
//        for(int i = 0; i < friends.length; i++) {
//            for(int j = i + 1; j < friends.length; j++) {
//                if(giftScoreMap.get(friends[i]) > giftScoreMap.get(friends[j])) {
//                    haveToRecv.put(friends[i], haveToRecv.get(friends[i])+1);
//                } else if
//            }
//        }
//
//        return answer;
//    }
//}
