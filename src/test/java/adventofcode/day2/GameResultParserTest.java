package adventofcode.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResultParserTest {
    private GameResultParser gameResultParser;

    @BeforeEach
    void setUp() { gameResultParser = new GameResultParser(); }

    @Test
    void canFilterGameResults() {
        String input = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";
        String expected = "1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";

        assertEquals(expected, gameResultParser.returnGameResults(input));
    }
    @Test
    void canFilterGameId() {
        String input = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";

        assertEquals("4", gameResultParser.returnGameId(input));
    }

    @Test
    void splitsGameIntoDraws() {
        //input
        String input = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";
        //expected
        Map<String, String> expectedHashMap = new HashMap<>();
        expectedHashMap.put("Draw1", "1 green, 3 red, 6 blue");
        expectedHashMap.put("Draw2", "3 green, 6 red");
        expectedHashMap.put("Draw3", "3 green, 15 blue, 14 red");

        assertEquals(expectedHashMap, gameResultParser.returnDrawsFromGame(input));
    }

    @Test
    void splitsGameIntoDraws2() {
        //input
        String input = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red; 1 red, 1 green, 1 blue";
        //expected
        Map<String, String> expectedHashMap = new HashMap<>();
        expectedHashMap.put("Draw1", "1 green, 3 red, 6 blue");
        expectedHashMap.put("Draw2", "3 green, 6 red");
        expectedHashMap.put("Draw3", "3 green, 15 blue, 14 red");
        expectedHashMap.put("Draw4", "1 red, 1 green, 1 blue");

        assertEquals(expectedHashMap, gameResultParser.returnDrawsFromGame(input));
    }

    @Test
    void comparesEachDrawWithMax() {
        //input
        String input = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";
        //expected
        boolean expectedResult = false;

        assertEquals(expectedResult, gameResultParser.isLessThanAllowedMax(input));
    }
    @Test
    void comparesEachDrawWithMax2() {
        //input
        String input = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
        //expected
        boolean expectedResult = false;

        assertEquals(expectedResult, gameResultParser.isLessThanAllowedMax(input));
    }
    @Test
    void comparesEachDrawWithMax3() {
        //input
        String input = "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";
        //expected
        boolean expectedResult = true;

        assertEquals(expectedResult, gameResultParser.isLessThanAllowedMax(input));
    }
}
