package adventofcode.day2;

import java.util.HashMap;
import java.util.Map;

public class CubePowerChecker {
    private final GameResultParser gameResultParser = new GameResultParser();

    public Map<String, Integer> returnMinimumRequiredCubes(String input) {
        Map<String, String> drawsInGame = gameResultParser.returnDrawsFromGame(input);

        Map<String, Integer> maxCubeCounts = new HashMap<>();

        for (Map.Entry<String, String> drawOfGame : drawsInGame.entrySet()) {
            String[] colors = drawOfGame.getValue().split(", ");

            for (String color : colors) {
                String[] parts = color.split(" ");
                int count = Integer.parseInt(parts[0]);
                String colorName = parts[1];

                int currentMax = maxCubeCounts.getOrDefault(colorName, 0);
                if (count > currentMax) {
                    maxCubeCounts.put(colorName, count);
                }
            }
        }
        return maxCubeCounts;
    }

    public int multiplyCubes(Map<String, Integer> input) {
        int result = 1;

        for (int value : input.values()) { result *= value; }

        return result;
    }

    public int returnMinCubesMultiplied(String input) {
        Map<String, Integer> minCubeCounts = returnMinimumRequiredCubes(input);
        return multiplyCubes(minCubeCounts);
    }
}
