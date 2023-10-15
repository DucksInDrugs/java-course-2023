package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.lang.Math.abs;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        logInfo();
    }

    public static void logInfo() {
        LOGGER.info("Привет, мир!");
    }

    @SuppressWarnings("MagicNumber")
    public static int videoLength(String length) {
        String[] time = length.split(":");
        if (time.length == 2) {
            try {
                int secondsInMinute = 60;
                int minutes = Integer.parseInt(time[0]);
                int seconds = Integer.parseInt(time[1]);
                if (minutes >= 0
                    && seconds >= 0
                    && seconds < secondsInMinute) {
                    return minutes * secondsInMinute + seconds;
                }
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    @SuppressWarnings("MagicNumber")
    public static int digitCount(int number) {
        int digits = 0;
        int changedNumber = number;
        if (number != 0) {
            while (changedNumber != 0) {
                changedNumber /= 10;
                digits++;
            }
            return digits;
        } else {
            return 1;
        }
    }

    public static boolean isNestable(int[] nested, int[] container) {
        int nestedMin = Arrays.stream(nested).min().getAsInt();
        int nestedMax = Arrays.stream(nested).max().getAsInt();
        int containerMin = Arrays.stream(container).min().getAsInt();
        int containerMax = Arrays.stream(container).max().getAsInt();
        return nestedMin > containerMin && nestedMax < containerMax;
    }

    public static String stringFix(String brokenString) {
        StringBuilder fixedString = new StringBuilder();
        if (brokenString.length() > 1) {
            for (int i = 0; i < brokenString.length() - 1; i += 2) {
                fixedString.append(brokenString.charAt(i + 1));
                fixedString.append(brokenString.charAt(i));
            }
            if (brokenString.length() % 2 == 1) {
                fixedString.append(brokenString.charAt(brokenString.length() - 1));
            }
            return new String(fixedString);
        } else {
            return brokenString;
        }
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindrome(int number) {
        String numberCopy = String.valueOf(abs(number));
        int i = 0;
        int j = numberCopy.length() - 1;

        while (i < j) {

            if (numberCopy.charAt(i) != numberCopy.charAt(j)) {
                if (numberCopy.length() % 2 == 0) {
                    int numberDescendant = 0;
                    for (int k = 0; k < numberCopy.length(); k += 2) {
                        numberDescendant += Math.pow(10, k / 2)
                            * (numberCopy.charAt(k) - '0' + numberCopy.charAt(k + 1) - '0');
                    }
                    if (number >= 10) {
                        numberCopy = String.valueOf(numberDescendant);
                        i = -1;
                        j = numberCopy.length();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    @SuppressWarnings("MagicNumber")
    public static int kaprekar(int number) {
        if (number == 6174 || number <= 1000 || number >= 9999) {
            return 0;
        } else {
            String stringNumber = String.valueOf(number);
            int[] num = new int[4];

            for (int i = 0; i < stringNumber.length(); i++) {
                num[i] = stringNumber.charAt(i) - '0';
            }
            Arrays.sort(num);
            int minNum = num[0] * 1000 + num[1] * 100 + num[2] * 10 + num[3];
            for (int i = 0; i < num.length / 2; i++) {
                int temp = num[i];
                num[i] = num[num.length - i - 1];
                num[num.length - i - 1] = temp;
            }
            int maxNum = num[0] * 1000 + num[1] * 100 + num[2] * 10 + num[3];
            if (maxNum - minNum != 0) {
                return 1 + kaprekar(maxNum - minNum);
            } else {
                return 0;
            }
        }
    }

    public static int rotateRight(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        String shiftedStr =
            binaryStr.substring(binaryStr.length() - shift) + binaryStr.substring(0, binaryStr.length() - shift);
        return Integer.parseInt(shiftedStr, 2);
    }

    public static int rotateLeft(int n, int shift) {
        String binaryStr = Integer.toBinaryString(n);
        String shiftedStr = binaryStr.substring(shift) + binaryStr.substring(0, shift);
        return Integer.parseInt(shiftedStr, 2);
    }

    private final static int[][] MOVES = {
        {1, 2},
        {1, -2},
        {2, 1},
        {2, -1}
    };

    public static boolean isKnightTakes(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    for (int[] direction : MOVES) {
                        int row = i + direction[0];
                        int col = j + direction[1];
                        if (isValidCell(row, col, rows, cols) && board[row][col] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValidCell(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
