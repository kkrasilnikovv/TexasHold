package org.example.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.example.constans.Combination;
import org.example.service.CombinationChoicer;

import java.util.Collections;
import java.util.List;

@Slf4j
@Getter
@ToString
public class PokerHand implements Comparable<PokerHand> {
    private final int id;
    private final List<Card> cards;
    private final Combination combination;

    public PokerHand(int id, List<Card> cards) {
        this.id = id;
        this.cards = cards;
        Collections.sort(cards);
        combination = CombinationChoicer.calculateCombination(cards);
    }

    @Override
    public int compareTo(@NonNull PokerHand o) {
        int combinationComparison = compareCombinations(o);
        if (combinationComparison != 0) {
            return combinationComparison;
        } else {
            return compareHighCardsDesc(o);
        }
    }

    private int compareCombinations(PokerHand other) {
        return Integer.compare(other.combination.getWeight(), this.combination.getWeight());
    }

    private int compareHighCardsDesc(PokerHand other) {
        int size = Math.min(cards.size(), other.cards.size());
        for (int i = 0; i < size; i++) {
            int result = Integer.compare(other.cards.get(i).nominal().getWeight(), cards.get(i).nominal().getWeight());
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(other.cards.size(), cards.size());
    }
}
