package adventofcode.day1;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Trebuchet {
    private final DigitFinder digitFinder = new DigitFinder();

    public int getCalibrateTrebuchet(Supplier<Stream<String>> dataSupplier) {
        return calibrateTrebuchet(dataSupplier.get());
    }

    public int getCalibrateTrebuchet(String... inputData) {
        return calibrateTrebuchet(Arrays.stream(inputData));
    }

    private int calibrateTrebuchet(Stream<String> stringStream) {
        return stringStream
                .map(this::calculateCalibrationValue)
                .flatMap(Optional::stream)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private Optional<String> calculateCalibrationValue(String s) {
        Optional<String> firstDigit = digitFinder.findFirstDigit(s);
        Optional<String> lastDigit = digitFinder.findLastDigit(s);
        if (firstDigit.isPresent() && lastDigit.isPresent())
            return of(firstDigit.get() + lastDigit.get());
        else return empty();
    }
}