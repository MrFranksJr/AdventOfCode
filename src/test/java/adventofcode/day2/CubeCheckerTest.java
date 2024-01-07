package adventofcode.day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CubeCheckerTest {
    private CubeChecker cubeChecker;
    @BeforeEach
    void setUp() { cubeChecker = new CubeChecker(); }

    @Test
    void canCompareCubeScores() {
        //input
        String input = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";

        assertTrue(cubeChecker.exceedsMaximumCubes(input));
    }

    @Test
    void canCompareCubeScores2() {
        String input = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";

        assertFalse(cubeChecker.exceedsMaximumCubes(input));
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
    void returnTotalIdsWithString() {
        //input
        String inputData = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
        //When
        int totalGameIds = cubeChecker.returnTotalIds(inputData);
        //expected
        assertEquals(0, totalGameIds);
    }
    @Test
    void returnTotalIdsWithString2() {
        //input
        String inputData = "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";
        //When
        int totalGameIds = cubeChecker.returnTotalIds(inputData);
        //expected
        assertEquals(5, totalGameIds);
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
