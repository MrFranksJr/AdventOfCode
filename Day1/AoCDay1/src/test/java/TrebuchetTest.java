import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrebuchetTest {

    private Trebuchet trebuchet;

    @BeforeEach
    void setUp() {
        trebuchet = new Trebuchet();
    }

    @Test
    void combinesFirstAndLastDigit() {
        assertEquals(55, trebuchet.getCalibrateTrebuchet("5glvnsztmnfjmkjseventdm4five"));
    }

    @Test
    void combinesFirstAndLastDigit2() {
        assertEquals(54, trebuchet.getCalibrateTrebuchet("5glvnsztmnfjmkjseventdm4"));
    }

    @Test
    void secondFirstAndLastIntegerOfString() {
        assertEquals(25, trebuchet.getCalibrateTrebuchet("twozsf2five"));
    }

    @Test
    void returnsSumsOfMultipleLinesOfInput() {

        assertEquals(289, trebuchet.getCalibrateTrebuchet(() -> InputFileReader.INSTANCE.readInputFile("src/test/resources/input.txt")));
    }

    @Test
    void returnsSumsOfMultipleLinesOfExampleInput() {

        assertEquals(142, trebuchet.getCalibrateTrebuchet(() -> InputFileReader.INSTANCE.readInputFile("src/test/resources/exampleInput.txt")));
    }

    @Test
    void returnsSumsOfMultipleLinesOfExampleInput2() {

        assertEquals(281, trebuchet.getCalibrateTrebuchet(() -> InputFileReader.INSTANCE.readInputFile("src/test/resources/exampleInput2.txt")));
    }

    @Test
    void returnSumOfFullInput() {

        assertEquals(54265, trebuchet.getCalibrateTrebuchet(() -> InputFileReader.INSTANCE.readInputFile("src/test/resources/fullInput.txt")));
    }

    @Test
    void checkInputGunnar() {
        //Given
        Supplier<Stream<String>> streamSupplier = () -> InputFileReader.INSTANCE.readInputFile("src/test/resources/gunnarInput.txt");
        //When
        int calibrateTrebuchet = trebuchet.getCalibrateTrebuchet(streamSupplier);
        //Then
        assertEquals(53340, calibrateTrebuchet);
    }


    @Test
    void multiStringTest() {
        //When
        int actual = trebuchet.getCalibrateTrebuchet("four66jqrbtqcsxjtqjvfjhl1", "5glvnsztmnfjmkjseventdm4five", "5glvnsztmnfjmkjseventdm4", "twozsf2five");
        //Then
        assertEquals(175, actual);
    }


}