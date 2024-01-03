import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkyCalibration {

    @Test
    void findsFirstDigitInString() {
        assertEquals("4", processString("four66jqrbtqcsxjtqjvfjhl1"));
    }

    @Test
    void findsLastDigitFromString() {
        assertEquals("3", processReverseString("four66jqrbtqcsxjtqjvf3hl"));
    }

    @Test
    void combinesFirstAndLastDigit() {
        assertEquals("55", combineFirstAndLastDigit("5glvnsztmnfjmkjseventdm4five"));
    }

    @Test
    void combinesFirstAndLastDigit2() {
        assertEquals("54", combineFirstAndLastDigit("5glvnsztmnfjmkjseventdm4"));
    }

    @Test
    void secondFirstAndLastIntegerOfString() {
        assertEquals("25", combineFirstAndLastDigit("twozsf2five"));
    }

    @Test
    void returnsSumsOfMultipleLinesOfInput() {
        assertEquals(289, parseMultipleLinesOfInput("src/test/resources/input.txt"));
    }

    @Test
    void returnsSumsOfMultipleLinesOfExampleInput() {
        assertEquals(142, parseMultipleLinesOfInput("src/test/resources/exampleInput.txt"));
    }

    @Test
    void returnsSumsOfMultipleLinesOfExampleInput2() {
        assertEquals(281, parseMultipleLinesOfInput("src/test/resources/exampleInput2.txt"));
    }

    @Test
    void returnSumOfFullInput() {
        assertEquals(54265, parseMultipleLinesOfInput("src/test/resources/fullInput.txt"));
    }

    private String processString(String s) {
        String tempString = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                return String.valueOf(c);
            } else {
                tempString += String.valueOf(c);
                if (checkForDigitsInText(tempString)) {
                    return convertDigits(tempString);
                }
            }
        }
        return "ERROR";
    }

    private String processReverseString(String s) {
        String tempString = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return String.valueOf(c);
            } else {
                tempString = c + tempString;
                if (checkForDigitsInText(tempString)) {
                    return convertDigits(tempString);
                }
            }
        }
        return "ERROR";
    }

    private String combineFirstAndLastDigit(String s) {
        String firstDigit = processString(s);
        String lastDigit = processReverseString(s);

        return firstDigit + lastDigit;
    }

    private boolean checkForDigitsInText(String s) {
        List<String> keywords = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        for (int i = 0; i < keywords.size(); i++) {
            Pattern word = Pattern.compile(keywords.get(i));
            Matcher match = word.matcher(s);
            if (match.find()) {
                return true;
            }
        }
        return false;
    }

    private String convertDigits(String tempString) {
        List<String> keywords = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        List<String> returnStrings = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

        for (int i = 0; i < keywords.size(); i++) {
            if (tempString.contains(keywords.get(i))) {
                return returnStrings.get(i);
            }
        }
        return null;
    }

    private Integer parseMultipleLinesOfInput(String inputPath) {
        int totalOfLines = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));

            String line = reader.readLine();

            while (line != null) {
                String combinedDigits = combineFirstAndLastDigit(line);
                totalOfLines += Integer.parseInt(combinedDigits);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return totalOfLines;
    }
}