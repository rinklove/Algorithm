import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        //선물 지수
        Map<String, Integer> giftScoreMap = new HashMap<>();
        //받은 선물 개수
        Map<String, Integer> getGifts = new HashMap<>();

        List<String> friendList = Arrays.asList(friends);
        int[][] giftGraph = new int[friends.length][friends.length];


        for (String p :
                friendList) {
            giftScoreMap.put(p, 0);
            getGifts.put(p, 0);

        }

        for (String log :
                gifts) {
            String[] tmp = log.split(" ");

            int give = friendList.indexOf(tmp[0]);
            int receive = friendList.indexOf(tmp[1]);

            giftScoreMap.put(tmp[0], giftScoreMap.get(tmp[0])+1);
            giftScoreMap.put(tmp[1], giftScoreMap.get(tmp[1])-1);
            giftGraph[give][receive]++;
        }

        for(int i = 0; i < giftGraph.length; i++) {
            for(int j = 0; j < i; j++) {

                String give = friendList.get(i);
                String receive = friendList.get(j);

                Integer score1 = giftScoreMap.get(give);
                Integer score2 = giftScoreMap.get(receive);

                //give가 선물을 준 횟수가 더 많은 경우
                if(giftGraph[i][j] > giftGraph[j][i]) {
                    //give에게 선물을 준다
                    getGifts.put(give, getGifts.get(give)+1);
                }
                //give가 선물을 받은 횟수가 더 많은 경우
                else if(giftGraph[i][j] < giftGraph[j][i]) {
                    //receive에게 선물을 준다.
                    getGifts.put(receive, getGifts.get(receive)+1);
                }
                //준 횟수가 같은 경우(0도 포함)
                else {
                    //선물 지수에 따라서 구분
                    if(score1 > score2) {
                        getGifts.put(give, getGifts.get(give)+1);
                    } else if(score1 < score2){
                        getGifts.put(receive, getGifts.get(receive)+1);
                    }
                }
            }
        }

        answer = getGifts.values().stream().mapToInt(i -> i).max().getAsInt();
        return answer;
    }
}