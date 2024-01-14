package org.example.service;

import org.example.constans.Combination;
import org.example.constans.Nominal;
import org.example.constans.Suit;
import org.example.model.Card;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Ищет комбинацию по переданным картам.
 */
public final class CombinationChoicer {
    /**
     * Ищет комбинацию по переданным картам.
     *
     * @param cards - список карт.
     * @return - найденную комбинацию.
     */
    public static Combination calculateCombination(List<Card> cards) {
        if (Objects.isNull(cards) || cards.isEmpty()) {
            return Combination.HIGH_CARD;
        } else {
            List<Card> sortedCards = cards.stream().sorted().toList();
            if (isRoyalFlush(sortedCards)) {
                return Combination.ROYAL_FLUSH;
            } else if (isStraightFlush(sortedCards)) {
                return Combination.STRAIGHT_FLUSH;
            } else if (isFourOfAKind(sortedCards)) {
                return Combination.FOUR_OF_A_KIND;
            } else if (isFullHouse(sortedCards)) {
                return Combination.FULL_HOUSE;
            } else if (isFlush(sortedCards)) {
                return Combination.FLUSH;
            } else if (isStraight(sortedCards)) {
                return Combination.STRAIGHT;
            } else if (isThreeOfAKind(sortedCards)) {
                return Combination.THREE_OF_A_KIND;
            } else if (isTwoPair(sortedCards)) {
                return Combination.TWO_PAIR;
            } else if (isOnePair(sortedCards)) {
                return Combination.ONE_PAIR;
            } else {
                // Если ни одна из комбинаций не подходит, то это высшая карта
                return Combination.HIGH_CARD;
            }
        }
    }

    /**
     * Проверяет все ли карты одной масти.
     *
     * @param cards - список карт.
     * @return - true(карты одной масти).
     */
    private static boolean isSameSuit(List<Card> cards) {
        Suit firstSuit = cards.get(0).suit();
        return cards.stream().allMatch(card -> card.suit() == firstSuit);
    }

    /**
     * Пять карт одной масти от десятки до туза.
     *
     * @param cards - список карт.
     * @return - true(комбинация найдена).
     */
    private static boolean isRoyalFlush(List<Card> cards) {
        if (!isSameSuit(cards)) {
            return false;
        }
        List<Nominal> nominals = cards.stream().map(Card::nominal).toList();
        List<Nominal> expectedNominals = Arrays.asList(Nominal.TEN, Nominal.JACK, Nominal.QUEEN, Nominal.KING, Nominal.ACE);
        return new HashSet<>(nominals).containsAll(expectedNominals);
    }

    /**
     * Пять последовательных карт одной масти.
     *
     * @param cards - список карт.
     * @return - true(комбинация найдена).
     */
    private static boolean isStraightFlush(List<Card> cards) {
        if (!isSameSuit(cards)) {
            return false;
        }

        // Проверяем, что карты идут подряд
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).nominal().getWeight() != cards.get(i).nominal().getWeight() + 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Четыре карты одного достоинства.
     *
     * @param cards - список карт.
     * @return - true(комбинация найдена).
     */
    private static boolean isFourOfAKind(List<Card> cards) {
        for (int i = 0; i < cards.size() - 3; i++) {
            if (cards.get(i).nominal().getWeight() == cards.get(i + 1).nominal().getWeight() &&
                    cards.get(i + 1).nominal().getWeight() == cards.get(i + 2).nominal().getWeight() &&
                    cards.get(i + 2).nominal().getWeight() == cards.get(i + 3).nominal().getWeight()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Три карты одного достоинства и пара карт другого достоинства.
     *
     * @param cards - список карт.
     * @return - true(комбинация найдена).
     */
    private static boolean isFullHouse(List<Card> cards) {
        return (cards.get(0).nominal().getWeight() == cards.get(1).nominal().getWeight() &&
                cards.get(1).nominal().getWeight() == cards.get(2).nominal().getWeight() &&
                cards.get(3).nominal().getWeight() == cards.get(4).nominal().getWeight()) ||
                (cards.get(0).nominal().getWeight() == cards.get(1).nominal().getWeight() &&
                        cards.get(2).nominal().getWeight() == cards.get(3).nominal().getWeight() &&
                        cards.get(3).nominal().getWeight() == cards.get(4).nominal().getWeight());
    }

    /**
     * Пять карт одной масти, не обязательно последовательных.
     *
     * @param cards - список карт.
     * @return - true(комбинация найдена).
     */
    private static boolean isFlush(List<Card> cards) {
        return isSameSuit(cards);
    }

    /**
     * Пять последовательных карт разных мастей.
     *
     * @param cards - список карт.
     * @return - true(комбинация найдена).
     */
    private static boolean isStraight(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).nominal().getWeight() != cards.get(i).nominal().getWeight() + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Три карты одного достоинства.
     *
     * @param cards - список карт.
     * @return - true(комбинация найдена).
     */
    private static boolean isThreeOfAKind(List<Card> cards) {
        for (int i = 0; i < cards.size() - 2; i++) {
            if (cards.get(i).nominal().getWeight() == cards.get(i + 1).nominal().getWeight() &&
                    cards.get(i + 1).nominal().getWeight() == cards.get(i + 2).nominal().getWeight()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Две пары карт одного достоинства.
     *
     * @param cards - список карт.
     * @return - true(комбинация найдена).
     */
    private static boolean isTwoPair(List<Card> cards) {
        int pairCount = 0;
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).nominal().getWeight() == cards.get(i + 1).nominal().getWeight()) {
                pairCount++;
                i++;
            }
        }
        return pairCount == 2;
    }

    /**
     * Одна пара карт одного достоинства.
     *
     * @param cards - список карт.
     * @return - true(комбинация найдена).
     */
    private static boolean isOnePair(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).nominal().getWeight() == cards.get(i + 1).nominal().getWeight()) {
                return true;
            }
        }
        return false;
    }

    private CombinationChoicer() {
    }
}