package adventofcode.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitFinderTest {

    private DigitFinder digitFinder;

    @BeforeEach
    void setUp() {
        digitFinder = new DigitFinder();
    }

    @Test
    void findFirstDigit() {
        assertEquals("4", digitFinder.findFirstDigit("four66jqrbtqcsxjtqjvfjhl1"));
    }

    @Test
    void findLastDigit() {
        assertEquals("3", digitFinder.findLastDigit("four66jqrbtqcsxjtqjvf3hl"));
    }
}