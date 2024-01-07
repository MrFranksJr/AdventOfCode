package adventofcode.day2;

import adventofcode.day1.InputFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeLimitCheckerTest {
    private CubeLimitChecker cubeLimitChecker;
    @BeforeEach
    void setUp() { cubeLimitChecker = new CubeLimitChecker(); }
    @Test
    void comparesEachDrawWithMax() {
        //input
        String input = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";
        //expected
        boolean expectedResult = false;

        assertEquals(expectedResult, cubeLimitChecker.isLessThanAllowedMax(input));
    }
    @Test
    void comparesEachDrawWithMax2() {
        //input
        String input = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
        //expected
        boolean expectedResult = false;

        assertEquals(expectedResult, cubeLimitChecker.isLessThanAllowedMax(input));
    }
    @Test
    void comparesEachDrawWithMax3() {
        //input
        String input = "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";
        //expected
        boolean expectedResult = true;

        assertEquals(expectedResult, cubeLimitChecker.isLessThanAllowedMax(input));
    }
}
