package 프로그래머스.Hash;

import java.util.*;
import java.util.stream.Collectors;

public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        HashMap<String, List<Music>> genrestable = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            List<Music> musicList = genrestable.getOrDefault(genres[i], new LinkedList<>());
            musicList.add(new Music(i, plays[i]));
            genrestable.put(genres[i], musicList);
        }

        List<String> priorityOfGenres = priorityOfGenre(genres, plays);

        List<Integer> answerList = new LinkedList<>();
        for (String genreName : priorityOfGenres) {
            List<Music> musicList = genrestable.get(genreName);
            Collections.sort(musicList);

            answerList.add(musicList.get(0).index);

            if (musicList.size() > 1) {
                answerList.add(musicList.get(1).index);
            }
        }

        int[] answer = new int[answerList.size()];
        int index = 0;
        for (int i : answerList) {
            answer[index++] = i;
        }

        return answer;
    }

    static List<String> priorityOfGenre(String[] genres, int[] plays) {
        HashMap<String, Integer> genre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> priorityGenres = new LinkedList<>(genre.keySet());
        priorityGenres.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return genre.get(o1) - genre.get(o1);
            }
        });

        return priorityGenres;
    }

    static class Music implements Comparable<Music> {
        int index;
        int plays;

        public Music(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }

        @Override
        public int compareTo(Music o) {
            if (o.plays > this.plays) {
                return 1;
            }

            if (o.plays == this.plays) {
                return this.index - o.index;
            }

            return -1;
        }
    }
}
