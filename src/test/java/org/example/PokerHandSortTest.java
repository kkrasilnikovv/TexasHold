package org.example;

import org.example.constans.Nominal;
import org.example.constans.Suit;
import org.example.model.Card;
import org.example.model.PokerHand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandSortTest {
    private static List<PokerHand> cards;
    private static PokerHand royalFlush;
    private static PokerHand straightFlush;
    private static PokerHand fourOfAKind;
    private static PokerHand fullHouse;
    private static PokerHand flush;
    private static PokerHand straight;
    private static PokerHand threeOfAKind;
    private static PokerHand twoPair;
    private static PokerHand onePair;
    private static PokerHand highCard1;
    private static PokerHand highCard2;
    private static PokerHand highCard3;

    @BeforeAll
    static void init() {
        cards = new ArrayList<>();
        royalFlush = new PokerHand(1, Arrays.asList(
                new Card(Nominal.TEN, Suit.SPADES),
                new Card(Nominal.JACK, Suit.SPADES),
                new Card(Nominal.QUEEN, Suit.SPADES),
                new Card(Nominal.KING, Suit.SPADES),
                new Card(Nominal.ACE, Suit.SPADES)));

        straightFlush = new PokerHand(2, Arrays.asList(
                new Card(Nominal.FIVE, Suit.DIAMONDS),
                new Card(Nominal.SIX, Suit.DIAMONDS),
                new Card(Nominal.SEVEN, Suit.DIAMONDS),
                new Card(Nominal.EIGHT, Suit.DIAMONDS),
                new Card(Nominal.NINE, Suit.DIAMONDS)));

        fourOfAKind = new PokerHand(3, Arrays.asList(
                new Card(Nominal.TEN, Suit.HEARTS),
                new Card(Nominal.TEN, Suit.SPADES),
                new Card(Nominal.TEN, Suit.DIAMONDS),
                new Card(Nominal.TEN, Suit.CLUBS),
                new Card(Nominal.KING, Suit.HEARTS)));

        fullHouse = new PokerHand(4, Arrays.asList(
                new Card(Nominal.JACK, Suit.CLUBS),
                new Card(Nominal.JACK, Suit.DIAMONDS),
                new Card(Nominal.JACK, Suit.HEARTS),
                new Card(Nominal.TWO, Suit.SPADES),
                new Card(Nominal.TWO, Suit.CLUBS)));

        flush = new PokerHand(5, Arrays.asList(
                new Card(Nominal.TWO, Suit.HEARTS),
                new Card(Nominal.FOUR, Suit.HEARTS),
                new Card(Nominal.SIX, Suit.HEARTS),
                new Card(Nominal.EIGHT, Suit.HEARTS),
                new Card(Nominal.KING, Suit.HEARTS)));

        straight = new PokerHand(6, Arrays.asList(
                new Card(Nominal.SEVEN, Suit.CLUBS),
                new Card(Nominal.EIGHT, Suit.SPADES),
                new Card(Nominal.NINE, Suit.DIAMONDS),
                new Card(Nominal.TEN, Suit.HEARTS),
                new Card(Nominal.JACK, Suit.SPADES)));

        threeOfAKind = new PokerHand(7, Arrays.asList(
                new Card(Nominal.ACE, Suit.CLUBS),
                new Card(Nominal.ACE, Suit.DIAMONDS),
                new Card(Nominal.ACE, Suit.HEARTS),
                new Card(Nominal.TWO, Suit.SPADES),
                new Card(Nominal.FOUR, Suit.CLUBS)));

        twoPair = new PokerHand(8, Arrays.asList(
                new Card(Nominal.SEVEN, Suit.CLUBS),
                new Card(Nominal.SEVEN, Suit.SPADES),
                new Card(Nominal.JACK, Suit.DIAMONDS),
                new Card(Nominal.JACK, Suit.HEARTS),
                new Card(Nominal.NINE, Suit.CLUBS)));

        onePair = new PokerHand(9, Arrays.asList(
                new Card(Nominal.FIVE, Suit.SPADES),
                new Card(Nominal.FIVE, Suit.DIAMONDS),
                new Card(Nominal.TWO, Suit.HEARTS),
                new Card(Nominal.SEVEN, Suit.CLUBS),
                new Card(Nominal.QUEEN, Suit.HEARTS)));

        highCard1 = new PokerHand(10, Arrays.asList(
                new Card(Nominal.ACE, Suit.CLUBS),
                new Card(Nominal.NINE, Suit.SPADES),
                new Card(Nominal.FOUR, Suit.DIAMONDS),
                new Card(Nominal.SEVEN, Suit.HEARTS),
                new Card(Nominal.KING, Suit.CLUBS)));

        highCard2 = new PokerHand(11, Arrays.asList(
                new Card(Nominal.TEN, Suit.CLUBS),
                new Card(Nominal.EIGHT, Suit.SPADES),
                new Card(Nominal.FOUR, Suit.DIAMONDS),
                new Card(Nominal.SEVEN, Suit.HEARTS),
                new Card(Nominal.KING, Suit.CLUBS)));

        highCard3 = new PokerHand(12, Arrays.asList(
                new Card(Nominal.QUEEN, Suit.HEARTS),
                new Card(Nominal.SIX, Suit.SPADES),
                new Card(Nominal.THREE, Suit.DIAMONDS),
                new Card(Nominal.TWO, Suit.HEARTS),
                new Card(Nominal.NINE, Suit.CLUBS)));
    }

    @AfterEach
    void clear() {
        cards.clear();
    }

    @Test
    void testSortAllCombinations() {
        cards.add(royalFlush);
        cards.add(straightFlush);
        cards.add(fourOfAKind);
        cards.add(fullHouse);
        cards.add(flush);
        cards.add(straight);
        cards.add(threeOfAKind);
        cards.add(twoPair);
        cards.add(onePair);
        cards.add(highCard1);
        cards.add(highCard2);
        cards.add(highCard3);

        shuffleAndSort();

        assertEquals(royalFlush, cards.get(0));
        assertEquals(straightFlush, cards.get(1));
        assertEquals(fourOfAKind, cards.get(2));
        assertEquals(fullHouse, cards.get(3));
        assertEquals(flush, cards.get(4));
        assertEquals(straight, cards.get(5));
        assertEquals(threeOfAKind, cards.get(6));
        assertEquals(twoPair, cards.get(7));
        assertEquals(onePair, cards.get(8));
        assertEquals(highCard1, cards.get(9));
        assertEquals(highCard2, cards.get(10));
        assertEquals(highCard3, cards.get(11));
    }

    @Test
    void testRoyalFlushSorting() {
        cards.add(royalFlush);
        cards.add(straightFlush);
        cards.add(fourOfAKind);

        shuffleAndSort();

        assertEquals(royalFlush, cards.get(0));
        assertEquals(straightFlush, cards.get(1));
        assertEquals(fourOfAKind, cards.get(2));
    }

    @Test
    void testStraightFlushSorting() {
        cards.add(straightFlush);
        cards.add(fourOfAKind);
        cards.add(fullHouse);

        shuffleAndSort();

        assertEquals(straightFlush, cards.get(0));
        assertEquals(fourOfAKind, cards.get(1));
        assertEquals(fullHouse, cards.get(2));
    }

    @Test
    void testFourOfAKindSorting() {
        cards.add(fourOfAKind);
        cards.add(fullHouse);
        cards.add(flush);

        shuffleAndSort();

        assertEquals(fourOfAKind, cards.get(0));
        assertEquals(fullHouse, cards.get(1));
        assertEquals(flush, cards.get(2));
    }

    @Test
    void testFullHouseSorting() {
        cards.add(fullHouse);
        cards.add(flush);
        cards.add(straight);

        shuffleAndSort();

        assertEquals(fullHouse, cards.get(0));
        assertEquals(flush, cards.get(1));
        assertEquals(straight, cards.get(2));
    }

    @Test
    void testFlushSorting() {
        cards.add(flush);
        cards.add(straight);
        cards.add(threeOfAKind);

        shuffleAndSort();

        assertEquals(flush, cards.get(0));
        assertEquals(straight, cards.get(1));
        assertEquals(threeOfAKind, cards.get(2));
    }

    @Test
    void testStraightSorting() {
        cards.add(straight);
        cards.add(threeOfAKind);
        cards.add(twoPair);

        shuffleAndSort();

        assertEquals(straight, cards.get(0));
        assertEquals(threeOfAKind, cards.get(1));
        assertEquals(twoPair, cards.get(2));
    }

    @Test
    void testThreeOfAKindSorting() {
        cards.add(threeOfAKind);
        cards.add(twoPair);
        cards.add(onePair);

        shuffleAndSort();

        assertEquals(threeOfAKind, cards.get(0));
        assertEquals(twoPair, cards.get(1));
        assertEquals(onePair, cards.get(2));
    }

    @Test
    void testTwoPairSorting() {
        cards.add(twoPair);
        cards.add(onePair);
        cards.add(highCard1);

        shuffleAndSort();

        assertEquals(twoPair, cards.get(0));
        assertEquals(onePair, cards.get(1));
        assertEquals(highCard1, cards.get(2));
    }

    @Test
    void testOnePairSorting() {
        cards.add(onePair);
        cards.add(highCard1);
        cards.add(highCard2);

        shuffleAndSort();

        assertEquals(onePair, cards.get(0));
        assertEquals(highCard1, cards.get(1));
        assertEquals(highCard2, cards.get(2));
    }

    @Test
    void testHighCardSorting() {
        cards.add(highCard1);
        cards.add(highCard2);
        cards.add(highCard3);

        shuffleAndSort();

        assertEquals(highCard1, cards.get(0));
        assertEquals(highCard2, cards.get(1));
        assertEquals(highCard3, cards.get(2));
    }

    void shuffleAndSort() {
        Collections.shuffle(cards);
        Collections.sort(cards);
    }
}
