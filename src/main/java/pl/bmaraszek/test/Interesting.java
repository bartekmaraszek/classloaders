package pl.bmaraszek.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Interesting {

    private static List<String> pairs = Arrays.asList("tokyo", "kyoto", "bartek", "ekbart", "tekbar", "short", "loooooooooong");

    public static void main(String[] args) {
        Interesting interesting = new Interesting();
        int i = interesting.count(pairs);
        System.out.println(i);
    }

    public int count(Collection<String> words) {
        ArrayList<String> list = new ArrayList<>(words);
        int count = 0;
        for(int i = 0; i < words.size() - 1; i++) {
            for(int j = i+1; j < words.size(); j++) {
                if(isInteresting(list.get(i), list.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isInteresting(String wordOne, String wordTwo) {
        return wordOne.concat(wordOne).contains(wordTwo);
    }
}
