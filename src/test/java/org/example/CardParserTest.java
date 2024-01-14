package org.example;

import org.example.constans.Nominal;
import org.example.constans.Suit;
import org.example.model.Card;
import org.example.service.CardParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CardParserTest {
    @Test
    void testParsingCard() {
        List<Card> cards1 = CardParser.parsingCard("2C 3D 4H 5S 6D");
        assertThat(cards1)
                .hasSize(5)
                .containsExactly(
                        new Card(Nominal.TWO, Suit.CLUBS),
                        new Card(Nominal.THREE, Suit.DIAMONDS),
                        new Card(Nominal.FOUR, Suit.HEARTS),
                        new Card(Nominal.FIVE, Suit.SPADES),
                        new Card(Nominal.SIX, Suit.DIAMONDS));

        List<Card> cards2 = CardParser.parsingCard("KS QC AH TD JS");
        assertThat(cards2)
                .hasSize(5)
                .containsExactly(
                        new Card(Nominal.KING, Suit.SPADES),
                        new Card(Nominal.QUEEN, Suit.CLUBS),
                        new Card(Nominal.ACE, Suit.HEARTS),
                        new Card(Nominal.TEN, Suit.DIAMONDS),
                        new Card(Nominal.JACK, Suit.SPADES));

        List<Card> cards3 = CardParser.parsingCard("7H 8D 9S TC JH");
        assertThat(cards3)
                .hasSize(5)
                .containsExactly(
                        new Card(Nominal.SEVEN, Suit.HEARTS),
                        new Card(Nominal.EIGHT, Suit.DIAMONDS),
                        new Card(Nominal.NINE, Suit.SPADES),
                        new Card(Nominal.TEN, Suit.CLUBS),
                        new Card(Nominal.JACK, Suit.HEARTS));
    }

    @Test
    void testParsingCardNullInput() {
        List<Card> cards = CardParser.parsingCard(null);
        assertThat(cards).isEmpty();
    }

    @Test
    void testParsingCardEmptyInput() {
        List<Card> cards = CardParser.parsingCard("");
        assertThat(cards).isEmpty();
    }

    @Test
    void testParsingCardInvalidInput() {
        List<Card> cards = CardParser.parsingCard("2C 3D 4H 5S X");
        assertThat(cards).isEmpty();
    }
}