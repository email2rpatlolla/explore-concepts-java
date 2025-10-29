package com.practices.concepts.collection;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class SequencedCollection {

    public static void main(String[] args) {
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();

        sequencedSet.add("red");
        sequencedSet.add("green");
        sequencedSet.addFirst("white");
        sequencedSet.addFirst("green");
        sequencedSet.addLast("blue");
        sequencedSet.add("yellow");
        sequencedSet.add("red");

        System.out.println("Sequenced Set: " + sequencedSet); // [green, white, red, blue, yellow]
    }
}
