package adventofcode.day2;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CubeChecker {
    private final GameResultParser gameResultParser = new GameResultParser();
    public String getGameResults(String s) { return gameResultParser.returnGameResults(s); }
    public String getGameId(String s) { return gameResultParser.returnGameId(s); }
    public Map<String, String> getDrawsInGame(String s) { return gameResultParser.returnDrawsFromGame(s); }
    public boolean compareDrawsWithMaxCubes(String s) { return gameResultParser.isLessThanAllowedMax(s); }
    public boolean exceedsMaximumCubes(String s) { return gameResultParser.isLessThanAllowedMax(s); }


    public int returnTotalIds(Supplier<Stream<String>> dataSupplier) {
        return calulcateTotalIds(dataSupplier.get());
    }

    private int calulcateTotalIds(Stream<String> stringStream) {
        int totalOfGameIDs = 0;

        List<String> validGames = stringStream
                .filter(this::exceedsMaximumCubes)
                .toList();

        for (String game : validGames) {
            totalOfGameIDs += Integer.parseInt(getGameId(game));
            System.out.println(totalOfGameIDs);
        }

        return totalOfGameIDs;
    }
}
