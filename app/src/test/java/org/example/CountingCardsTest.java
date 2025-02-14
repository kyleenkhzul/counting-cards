/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class CountingCardsTest {
    // Static arrays to be shuffled
    private static final int[] ARRAY_1 = {1, 2, 3, 4, 5};
    private static final int[] ARRAY_2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final int[] ARRAY_3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150};
    private static final int[] ARRAY_4 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};

    // Helper method for running a shuffle test on an array
    private void runShuffleTest(int[] array, String shuffleType) {
        for (int i = 0; i < 4; i++) {
            int[] shuffled = new int[array.length];
            switch (shuffleType) {
                case "first":
                    shuffled = CountingCards.firstShuffle(array);
                    break;
                case "second":
                    shuffled = CountingCards.secondShuffle(array);
                    break;
                case "third":
                    shuffled = array.clone();
                    CountingCards.thirdShuffle(shuffled);
                    break;
            }
            assertFalse(Arrays.equals(array, shuffled), shuffleType + " shuffle failed on trial " + (i + 1));
        }
    }

    // Tests for firstShuffle
    @Test
    void testFirstShuffle() {
        runShuffleTest(ARRAY_1, "first");
        runShuffleTest(ARRAY_2, "first");
        runShuffleTest(ARRAY_3, "first");
        runShuffleTest(ARRAY_4, "first");
    }

    // Tests for secondShuffle
    @Test
    void testSecondShuffle() {
        runShuffleTest(ARRAY_1, "second");
        runShuffleTest(ARRAY_2, "second");
        runShuffleTest(ARRAY_3, "second");
        runShuffleTest(ARRAY_4, "second");
    }

    // Tests for thirdShuffle (Fisher-Yates)
    @Test
    void testThirdShuffle() {
        runShuffleTest(ARRAY_1, "third");
        runShuffleTest(ARRAY_2, "third");
        runShuffleTest(ARRAY_3, "third");
        runShuffleTest(ARRAY_4, "third");
    }
}
