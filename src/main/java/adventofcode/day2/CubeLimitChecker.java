package adventofcode.day2;

import java.util.Map;

public class CubeLimitChecker {
    private static final Map<String, Integer> CUBE_LIMIT;
    static {
        CUBE_LIMIT = Map.of("red", 12, "green", 13, "blue", 14);
    }
    private final GameResultParser gameResultParser = new GameResultParser();

    public boolean isLessThanAllowedMax(String s) {
        Map<String, String> drawsInGame = gameResultParser.returnDrawsFromGame(s);

        for (Map.Entry<String, String> drawOfGame : drawsInGame.entrySet()) {
            Map<String, Integer> mapOfDraw = GameResultParser.generateHashMapOfDraw(drawOfGame);
            for (Map.Entry<String, Integer> limitEntry : CUBE_LIMIT.entrySet()) {
                if (hasMoreCubesThanLimit(limitEntry, mapOfDraw)) return false;
            }
        }
        return true;
    }

    private static boolean hasMoreCubesThanLimit(Map.Entry<String, Integer> limitEntry, Map<String, Integer> mapOfDraw) {
        String key = limitEntry.getKey();
        int maxCubes = limitEntry.getValue();

        if (mapOfDraw.containsKey(key)) {
            int colorValue = mapOfDraw.get(key);

            return colorValue > maxCubes;
        }
        return false;
    }
}
