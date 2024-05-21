import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
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