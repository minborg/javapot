/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.minborgsjavapot.returnvalues;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pemi
 */
public class Java7 {

    public String poem() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Hey there my dearest baby small, ");
        sb.append("soon you will be big and tall");
        return sb.toString();
    }

    public Set<String> suits() {
        final Set<String> result = new HashSet<>();
        result.add("Hearts");
        result.add("Spades");
        result.add("Diamonds");
        result.add("Clubs");
        return Collections.unmodifiableSet(result);
    }
    
}
