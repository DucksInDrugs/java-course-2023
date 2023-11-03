package edu.hw3.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

public class RomanNumbersConverter {
    @SuppressWarnings("MagicNumber")
    public String convertToRoman(int arabicNumber) {
        if (arabicNumber < 0) {
            return null;
        }
        int convertingNumber = arabicNumber;
        StringBuilder answer = new StringBuilder();
        Map<Integer, String> roman = Map.ofEntries(
            entry(1, "I"), entry(4, "IV"), entry(5, "V"), entry(9, "IX"), entry(10, "X"),
            entry(40, "XL"), entry(50, "L"), entry(90, "XC"), entry(100, "C"),
            entry(400, "CD"), entry(500, "D"), entry(900, "CM"), entry(1000, "M"));

        List<Integer> romanNumerals = new ArrayList<>(roman.keySet());
        romanNumerals.sort(Collections.reverseOrder());
        for (Integer numeral: romanNumerals) {
            if (convertingNumber >= numeral) {
                int countOfNumeral = convertingNumber / numeral;
                answer.append(roman.get(numeral).repeat(countOfNumeral));
                convertingNumber -= countOfNumeral * numeral;
            }
        }
        return new String(answer);
    }
}
