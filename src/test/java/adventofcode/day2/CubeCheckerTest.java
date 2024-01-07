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
        int totalGameIds = cubeChecker.returnTotalValidIds(streamSupplier);
        //expected
        assertEquals(8, totalGameIds);
    }

    @Test
    void returnTotalIdsWithString() {
        //input
        String inputData = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
        //When
        int totalGameIds = cubeChecker.returnTotalValidIds(inputData);
        //expected
        assertEquals(0, totalGameIds);
    }
    @Test
    void returnTotalIdsWithString2() {
        //input
        String inputData = "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";
        //When
        int totalGameIds = cubeChecker.returnTotalValidIds(inputData);
        //expected
        assertEquals(5, totalGameIds);
    }
    @Test
    void returnTotalIdsFull() {
        //input
        Supplier<Stream<String>> streamSupplier = () -> InputFileReader.INSTANCE.readInputFile("src/test/resources/day2/fullinput.txt");
        //When
        int totalGameIds = cubeChecker.returnTotalValidIds(streamSupplier);
        //expected
        assertEquals(2512, totalGameIds);
    }


    @Test
    void cubePowerMainMethodTestWithString1() {
        //input
        String input = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";
        //expected
        int expectedResult = 630;
        assertEquals(expectedResult, cubeChecker.returnPowerOfMinimumCubes(input));
    }

    @Test
    void cubePowerMainMethodTestWithString2() {
        //input
        String input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        //expected
        int expectedResult = 48;
        assertEquals(expectedResult, cubeChecker.returnPowerOfMinimumCubes(input));
    }
    @Test
    void cubePowerMainMethodTestWithString3() {
        //input
        String input = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
        //expected
        int expectedResult = 1560;
        assertEquals(expectedResult, cubeChecker.returnPowerOfMinimumCubes(input));
    }

    @Test
    void cubePowerMainMethodTestWithSampleInput() {
        //Given
        Supplier<Stream<String>> streamSupplier = () -> adventofcode.day1.InputFileReader.INSTANCE.readInputFile("src/test/resources/day2/sampleinput.txt");
        //When
        int expectedResult = cubeChecker.returnPowerOfMinimumCubes(streamSupplier);
        //Then
        assertEquals(2286, expectedResult);
    }


    @Test
    void cubePowerMainMethodTestWithFullInput() {
        //Given
        Supplier<Stream<String>> streamSupplier = () -> adventofcode.day1.InputFileReader.INSTANCE.readInputFile("src/test/resources/day2/fullinput.txt");
        //When
        int expectedResult = cubeChecker.returnPowerOfMinimumCubes(streamSupplier);
        //Then
        assertEquals(67335, expectedResult);
    }
}
