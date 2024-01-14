package org.example.constans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.exception.NonFoundException;

import java.util.Arrays;

/**
 * Масти игральных карт.
 */
@Getter
@AllArgsConstructor
public enum Suit {
    SPADES("S"),
    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C");
    private final String value;

    /**
     * Возвращает enum соответствующий переданному значению.
     *
     * @param value - строковое представление.
     * @return - enum, значение которого совпадает с переданным значение value.
     * @throws NonFoundException - возникает в случае ненахождения.
     */
    public static Suit contains(String value) throws NonFoundException {
        return Arrays.stream(Suit.values())
                .filter(v -> v.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new NonFoundException("Не найдена масть:" + value));
    }
}