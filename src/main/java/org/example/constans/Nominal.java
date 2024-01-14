package org.example.constans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.exception.NonFoundException;

import java.util.Arrays;

/**
 * Номинал игральных карт.
 */
@Getter
@AllArgsConstructor
public enum Nominal {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14);
    //Обозначение
    private final String value;
    //Вес
    private final int weight;

    /**
     * Возвращает enum соответствующий переданному значению.
     *
     * @param value - строковое представление.
     * @return - enum, значение которого совпадает с переданным значение value.
     * @throws NonFoundException - возникает в случае ненахождения.
     */
    public static Nominal contains(String value) throws NonFoundException {
        return Arrays.stream(Nominal.values())
                .filter(v -> v.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new NonFoundException("Не найдено значение:" + value));
    }
}
