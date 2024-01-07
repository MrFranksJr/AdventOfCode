package adventofcode.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CubeMinPowerCheckerTest {
    private CubeMinPowerChecker cubeMinPowerChecker;
    @BeforeEach
    void setUp() { cubeMinPowerChecker = new CubeMinPowerChecker(); }
    @Test
    void returnsMinimumRequiredCubes() {
        //input
        String input = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red; 1 red, 1 green, 1 blue";
        //expected
        Map<String, Integer> expectedHashMap = new HashMap<>();
        expectedHashMap.put("red", 14);
        expectedHashMap.put("green", 3);
        expectedHashMap.put("blue", 15);

        assertEquals(expectedHashMap, cubeMinPowerChecker.returnMinimumRequiredCubes(input));
    }
    @Test
    void returnsMinimumRequiredCubes2() {
        //input
        String input = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";
        //expected
        Map<String, Integer> expectedHashMap = new HashMap<>();
        expectedHashMap.put("red", 1);
        expectedHashMap.put("green", 3);
        expectedHashMap.put("blue", 4);

        assertEquals(expectedHashMap, cubeMinPowerChecker.returnMinimumRequiredCubes(input));
    }
    @Test
    void multipliesMinimumCubes() {
        //input
        Map<String, Integer> input = new HashMap<>();
        input.put("red", 1);
        input.put("green", 3);
        input.put("blue", 4);
        //expected
        int expectedResult = 12;
        assertEquals(expectedResult, cubeMinPowerChecker.multiplyCubes(input));
    }
}
