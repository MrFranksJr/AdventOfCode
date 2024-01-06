package adventofcode.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CubeCheckerTest {

    private CubeChecker cubeChecker;
    @BeforeEach
    void setUp() {
        cubeChecker = new CubeChecker();
    }
    @Test
    void canFilterGameResults() {
        String input = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";
        String expected = "1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";

        assertEquals(expected, cubeChecker.getGameResults(input));
    }
    @Test
    void canFilterGameId() {
        String input = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";

        assertEquals("4", cubeChecker.getGameId(input));
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

        assertEquals(expectedHashMap, cubeChecker.getDrawsInGame(input));
    }

    @Test
    void comparesEachDrawWithMax() {
        //input
        String input = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";
        //expected
        boolean expectedResult = false;

        assertEquals(expectedResult, cubeChecker.compareDrawsWithMaxCubes(input));
    }
    @Test
    void comparesEachDrawWithMax2() {
        //input
        String input = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
        //expected
        boolean expectedResult = false;

        assertEquals(expectedResult, cubeChecker.compareDrawsWithMaxCubes(input));
    }

    @Test
    void canCompareCubeScores() {
        //input
        String input = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";

        assertEquals(true, cubeChecker.exceedsMaximumCubes(input));
    }

    @Test
    void canCompareCubeScores2() {
        String input = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";

        assertEquals(false, cubeChecker.exceedsMaximumCubes(input));
    }

    @Test
    void returnTotalIds() {
        //input
        Supplier<Stream<String>> streamSupplier = () -> InputFileReader.INSTANCE.readInputFile("src/test/resources/day2/sampleinput.txt");
        //When
        int totalGameIds = cubeChecker.returnTotalIds(streamSupplier);
        //expected
        assertEquals(8, totalGameIds);
    }
    @Test
    void returnTotalIdsFull() {
        //input
        Supplier<Stream<String>> streamSupplier = () -> InputFileReader.INSTANCE.readInputFile("src/test/resources/day2/fullinput.txt");
        //When
        int totalGameIds = cubeChecker.returnTotalIds(streamSupplier);
        //expected
        assertEquals(2512, totalGameIds);
    }
}
