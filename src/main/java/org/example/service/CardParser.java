package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.constans.Nominal;
import org.example.constans.Suit;
import org.example.exception.NonFoundException;
import org.example.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public final class CardParser {
    /**
     * Преобразует строковое представление в объекты {@link Card}.
     *
     * @param cards - карты в формате строки.
     * @return - список карт в формате объектов {@link Card}.
     */
    public static List<Card> parsingCard(String cards) {
        List<Card> result = new ArrayList<>();
        if (Objects.isNull(cards) || cards.isBlank()) {
            return result;
        }

        try {
            String[] parsingCards = cards.split(" ");
            for (String card : parsingCards) {
                String[] valueAndSuit = card.split("");

                Nominal nominal = Nominal.contains(valueAndSuit[0]);
                Suit suit = Suit.contains(valueAndSuit[1]);
                result.add(new Card(nominal, suit));
            }
        } catch (NonFoundException e) {
            result.clear();
            log.error("Возникла ошибка при парсинге игральных карта. Ошибка:" + e.getMessage());
        }
        return result;
    }

    private CardParser() {
    }
}
