package org.example;

import org.example.constans.Combination;
import org.example.constans.Nominal;
import org.example.constans.Suit;
import org.example.model.Card;
import org.example.service.CombinationChoicer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationChoicerTest {
    @Test
    void testRoyalFlush() {
        List<Card> royalFlushCards = Arrays.asList(
                new Card(Nominal.TEN, Suit.SPADES),
                new Card(Nominal.JACK, Suit.SPADES),
                new Card(Nominal.QUEEN, Suit.SPADES),
                new Card(Nominal.KING, Suit.SPADES),
                new Card(Nominal.ACE, Suit.SPADES)
        );
        assertEquals(Combination.ROYAL_FLUSH, CombinationChoicer.calculateCombination(royalFlushCards));
    }

    @Test
    void testStraightFlush() {
        List<Card> straightFlushCards = Arrays.asList(
                new Card(Nominal.FOUR, Suit.HEARTS),
                new Card(Nominal.FIVE, Suit.HEARTS),
                new Card(Nominal.SIX, Suit.HEARTS),
                new Card(Nominal.SEVEN, Suit.HEARTS),
                new Card(Nominal.EIGHT, Suit.HEARTS)
        );
        assertEquals(Combination.STRAIGHT_FLUSH, CombinationChoicer.calculateCombination(straightFlushCards));
    }

    @Test
    void testFourOfAKind() {
        List<Card> fourOfAKindCards = Arrays.asList(
                new Card(Nominal.NINE, Suit.DIAMONDS),
                new Card(Nominal.NINE, Suit.HEARTS),
                new Card(Nominal.NINE, Suit.CLUBS),
                new Card(Nominal.NINE, Suit.SPADES),
                new Card(Nominal.TWO, Suit.HEARTS)
        );
        assertEquals(Combination.FOUR_OF_A_KIND, CombinationChoicer.calculateCombination(fourOfAKindCards));
    }

    @Test
    void testFullHouse() {
        List<Card> fullHouseCards1 = Arrays.asList(
                new Card(Nominal.TWO, Suit.DIAMONDS),
                new Card(Nominal.TWO, Suit.HEARTS),
                new Card(Nominal.TWO, Suit.SPADES),
                new Card(Nominal.THREE, Suit.CLUBS),
                new Card(Nominal.THREE, Suit.HEARTS)
        );
        assertEquals(Combination.FULL_HOUSE, CombinationChoicer.calculateCombination(fullHouseCards1));

        List<Card> fullHouseCards2 = Arrays.asList(
                new Card(Nominal.FOUR, Suit.SPADES),
                new Card(Nominal.FOUR, Suit.HEARTS),
                new Card(Nominal.FIVE, Suit.DIAMONDS),
                new Card(Nominal.FIVE, Suit.CLUBS),
                new Card(Nominal.FIVE, Suit.HEARTS)
        );
        assertEquals(Combination.FULL_HOUSE, CombinationChoicer.calculateCombination(fullHouseCards2));
    }

    @Test
    void testFlush() {
        List<Card> flushCards = Arrays.asList(
                new Card(Nominal.TWO, Suit.HEARTS),
                new Card(Nominal.FIVE, Suit.HEARTS),
                new Card(Nominal.SEVEN, Suit.HEARTS),
                new Card(Nominal.TEN, Suit.HEARTS),
                new Card(Nominal.KING, Suit.HEARTS)
        );
        assertEquals(Combination.FLUSH, CombinationChoicer.calculateCombination(flushCards));
    }

    @Test
    void testStraight() {
        List<Card> straightCards = Arrays.asList(
                new Card(Nominal.FOUR, Suit.CLUBS),
                new Card(Nominal.FIVE, Suit.HEARTS),
                new Card(Nominal.SIX, Suit.DIAMONDS),
                new Card(Nominal.SEVEN, Suit.SPADES),
                new Card(Nominal.EIGHT, Suit.CLUBS)
        );
        assertEquals(Combination.STRAIGHT, CombinationChoicer.calculateCombination(straightCards));
    }

    @Test
    void testThreeOfAKind() {
        List<Card> threeOfAKindCards = Arrays.asList(
                new Card(Nominal.NINE, Suit.DIAMONDS),
                new Card(Nominal.NINE, Suit.HEARTS),
                new Card(Nominal.NINE, Suit.CLUBS),
                new Card(Nominal.TWO, Suit.SPADES),
                new Card(Nominal.FOUR, Suit.HEARTS)
        );
        assertEquals(Combination.THREE_OF_A_KIND, CombinationChoicer.calculateCombination(threeOfAKindCards));
    }

    @Test
    void testTwoPair() {
        List<Card> twoPairCards = Arrays.asList(
                new Card(Nominal.FOUR, Suit.SPADES),
                new Card(Nominal.FOUR, Suit.HEARTS),
                new Card(Nominal.SEVEN, Suit.DIAMONDS),
                new Card(Nominal.SEVEN, Suit.CLUBS),
                new Card(Nominal.EIGHT, Suit.HEARTS)
        );
        assertEquals(Combination.TWO_PAIR, CombinationChoicer.calculateCombination(twoPairCards));
    }

    @Test
    void testOnePair() {
        List<Card> onePairCards = Arrays.asList(
                new Card(Nominal.TEN, Suit.CLUBS),
                new Card(Nominal.TEN, Suit.SPADES),
                new Card(Nominal.QUEEN, Suit.HEARTS),
                new Card(Nominal.KING, Suit.DIAMONDS),
                new Card(Nominal.ACE, Suit.CLUBS)
        );
        assertEquals(Combination.ONE_PAIR, CombinationChoicer.calculateCombination(onePairCards));
    }

    @Test
    void testHighCard() {
        List<Card> highCardCards = Arrays.asList(
                new Card(Nominal.TWO, Suit.SPADES),
                new Card(Nominal.FIVE, Suit.CLUBS),
                new Card(Nominal.SEVEN, Suit.HEARTS),
                new Card(Nominal.TEN, Suit.DIAMONDS),
                new Card(Nominal.KING, Suit.CLUBS)
        );
        assertEquals(Combination.HIGH_CARD, CombinationChoicer.calculateCombination(highCardCards));
    }

    @Test
    void testEmptyCardList() {
        List<Card> emptyCards = Collections.emptyList();
        assertEquals(Combination.HIGH_CARD, CombinationChoicer.calculateCombination(emptyCards));
    }

    @Test
    void testNullCardList() {
        List<Card> nullableCards = null;
        assertEquals(Combination.HIGH_CARD, CombinationChoicer.calculateCombination(nullableCards));
    }

}