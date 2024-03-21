package programmers;



import java.util.HashMap;
import java.util.Map;

public class Level1_달리기_경주 {

    /*
    시간 초과
     */
    public static void main(String[] args) {

        String[] solution = solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        for (String s : solution) {
            System.out.println("s = " + s);
        }
    }

    public static String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> rank = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (String calling : callings) {
            Integer i = rank.get(calling);
            rank.put(players[i-1], i);
            rank.put(calling, i-1);
            players[i] = players[i-1];
            players[i-1] = calling;
        }
        return players;
    }
}
