import java.util.*;

class Solution {
    //장르, 누적 재생횟수
    private final Map<String, Integer> count = new HashMap<>();
    //장르, 개수
    private final Map<String, List<int[]>> album = new HashMap<>();
    public int[] solution(String[] genres, int[] plays) {
        //[고유 번호, 재생 횟수, 누적 횟수]
        setAlbum(genres, plays);
        return setTrack();
    }
    
    private int[] setTrack() {
        List<Integer> track = new ArrayList<>();
        String[] genres = count.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .map(Map.Entry::getKey)
            .toArray(String[]::new);
        
        for(String g : genres) {
            List<int[]> list = album.get(g);
            int length = Math.min(2, list.size());
            for(int i = 0; i <length; i++) {
                track.add(list.get(i)[0]);
            }
        }
        return track.stream()
            .mapToInt(i ->i)
            .toArray();
    }
    
    private void setAlbum(String[] genres,int[] plays) {
        //각 장르의 누적 재생횟수 설정 + 각 장르의 앨범 설정
        for(int i = 0; i < genres.length; i++) {
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
            album.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }
        
         // 각 장르의 곡 리스트를 재생 횟수 기준으로 내림차순 정렬
        for (List<int[]> list : album.values()) {
            list.sort((a1, a2) -> a1[1] == a2[1] ? a1[0] - a2[0] : a2[1] - a1[1]);
        }
    }
}