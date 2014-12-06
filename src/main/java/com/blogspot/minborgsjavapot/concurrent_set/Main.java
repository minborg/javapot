package com.blogspot.minborgsjavapot.concurrent_set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import static javafx.scene.input.KeyCode.K;

/**
 *
 * @author pemi
 */
public class Main {

    public static void main(String[] args) {

        Map<String, Boolean> concurrentMap = new ConcurrentHashMap<>();
        Set<String> concurrentSet = Collections.newSetFromMap(concurrentMap);

        Set<String> conSet = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());

        final Set<String> characters = new HashSet<>(Arrays.asList("A", "B", "C"));

        final ConcurrentSet<String> set = new ConcurrentHashSet<>();

        set.add("Alice");
        set.add("Bob");
        set.add("Bob");

        set.addAll(characters);

        System.out.println(set);

        final ConcurrentSet<String> listSet = new ConcurrentHashSet<String>(ConcurrentSkipListMap::new);
        listSet.add("3");
        listSet.add("1");
        listSet.add("2");
        System.out.println(listSet);

        final Set<String> s = new ConcurrentHashSet<>();
        System.out.println(s.addAll(characters));
        System.out.println(s.addAll(characters));

    }

}
