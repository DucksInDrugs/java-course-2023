package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest {
    @Test
    void getVideoLength() {
        assertEquals(-1, Main.videoLength("mm:ss"));
        assertEquals(-1, Main.videoLength("-100:-100"));
        assertEquals(-1, Main.videoLength("-100:00"));
        assertEquals(-1, Main.videoLength(":-10"));
        assertEquals(-1, Main.videoLength("12:-10"));
        assertEquals(-1, Main.videoLength("10:60"));
        assertEquals(5999940, Main.videoLength("99999:00"));
        assertEquals(600, Main.videoLength("10:00"));
    }

    @Test
    void getDigitCount() {
        assertEquals(2, Main.digitCount(-10));
        assertEquals(2, Main.digitCount(10));
        assertEquals(1, Main.digitCount(0));
    }

    @Test
    void getIsNested(){
        assertTrue(Main.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 5}));
        assertFalse(Main.isNestable(new int[]{1, 2, 3, 4}, new int[]{0, 4}));
        assertFalse(Main.isNestable(new int[]{1, 2, 3, 4}, new int[]{1, 5}));
        assertFalse(Main.isNestable(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        assertTrue(Main.isNestable(new int[]{3, 1}, new int[]{4, 0}));
        assertFalse(Main.isNestable(new int[]{3, 1}, new int[]{3, 1}));
    }

    @Test
    void getFixedString(){
        Assertions.assertEquals("", Main.stringFix(""));
        Assertions.assertEquals("1", Main.stringFix("1"));
        Assertions.assertEquals("abcde", Main.stringFix("badce"));
        Assertions.assertEquals("This is a mixed up string.", Main.stringFix("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    void getIsPalindrome(){
        assertTrue(Main.isPalindrome(11211230));
        assertTrue(Main.isPalindrome(11));
        assertTrue(Main.isPalindrome(1));
        assertTrue(Main.isPalindrome(101));
        assertFalse(Main.isPalindrome(112));
        assertTrue(Main.isPalindrome(-11));
    }

    @Test
    void getKaprekar(){
        assertEquals(0, Main.kaprekar(1000));
        assertEquals(0, Main.kaprekar(1111));
        assertEquals(0, Main.kaprekar(10000));
        assertEquals(0, Main.kaprekar(6174));
        assertEquals(5, Main.kaprekar(6621));
    }

    @Test
    void getRotateRight(){
        assertEquals(1, Main.rotateRight(1, 1));
        assertEquals(4, Main.rotateRight(8, 1));
    }

    @Test
    void getRotateLeft(){
        assertEquals(1, Main.rotateLeft(16, 1));
        assertEquals(6, Main.rotateLeft(17, 2));
    }

    @Test
    void getKnights(){
        assertTrue(Main.isKnightTakes(new int[][]{
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}}));
        assertFalse(Main.isKnightTakes(new int[][]{
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}}));
    }
}
