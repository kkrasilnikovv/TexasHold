package org.example.model;

import org.example.constans.Nominal;
import org.example.constans.Suit;

public record Card(Nominal nominal, Suit suit) implements Comparable<Card> {
    @Override
    public int compareTo(Card o) {
        return this.nominal.getWeight() - o.nominal.getWeight();
    }
}
