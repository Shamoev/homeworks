package edu.sourceit.homeworks.homework8;

import java.util.*;

public class AnagramSorter {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("done", "none", "node", "neno", "onion", "deno", "gram", "ramg", "nioon");


        sortAnagrams(strings);
    }

    public static void sortAnagrams(List<String> strings) {
        Map<String, List<String>> map = new HashMap<>();
        String key;
        String item;
        for (int i = 0; i < strings.size(); i++) {
            item = strings.get(i);
            key = sortChars(strings.get(i));
            if (!map.containsKey(key)) {
                List<String> value = new ArrayList<>();
                value.add(item);
                map.put(key, value);
            } else {
                List<String> value = map.get(key);
                value.add(item);
            }
        }

        for (List<String> list : new ArrayList<List>(map.values())) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static String sortChars(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
