package com.blogspot.minborgsjavapot.alternating_interrface_exposure;

import java.util.Map;

/**
 *
 * @author pemi
 */
public class Main {

    public static void main(String[] args) {
        // Use the type safe builder
        Map<Integer, String> map = Maps.builder()
                .key(1).value("One")
                .key(2).value("Two")
                .key(10).value("Zehn'")
                .build();

        // Create an empty map
        Map<String, Integer> map2 = Maps.builder()
                .build();
        
        
    }

}
