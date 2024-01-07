package adventofcode.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameResultParser {
    String returnGameResults(String input) {
        final String gameResults = input.substring(input.indexOf(":") + 1);
        return gameResults.trim();
    }

    String returnGameId(String input) {
        String game = input.substring(0, input.indexOf(":"));

        Pattern pattern = Pattern.compile("Game (\\d+)");
        Matcher matcher = pattern.matcher(game);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return "ERROR";
    }

    Map<String, String> returnDrawsFromGame(String s) {
        String gameResults = returnGameResults(s);
        String[] subStrings = gameResults.split("\\s*;\\s*");
        int iteratorCount = 1;

        Map<String, String> drawsInGame = new HashMap<>();

        for (String subString : subStrings) {
            drawsInGame.put("Draw" + iteratorCount, subString);
            iteratorCount++;
        }

        return drawsInGame;
    }

    static Map<String, Integer> generateHashMapOfDraw(Map.Entry<String, String> drawOfGame) {
        Map<String, Integer> colorsAndCount = new HashMap<>();

        String[] allColorsInDraw = drawOfGame.getValue().split(", ");

        for (String kindOfCube : allColorsInDraw) {
            String[] colorAndAmount = kindOfCube.split(" ");
            if (colorAndAmount.length == 2) {
                int count = Integer.parseInt(colorAndAmount[0]);
                String color = colorAndAmount[1];

                colorsAndCount.put(color, count);
            }
        }
        return colorsAndCount;
    }
}