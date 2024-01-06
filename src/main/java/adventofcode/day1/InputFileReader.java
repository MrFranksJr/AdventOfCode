package adventofcode.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public enum InputFileReader {
    INSTANCE;
    public Stream<String> readInputFile(String inputFile) {
        try {
            final Path path = Paths.get(inputFile);
            return Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read " + inputFile, e);
        }
    }
}

