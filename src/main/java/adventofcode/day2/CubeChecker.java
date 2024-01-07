package adventofcode.day2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CubeChecker {
    private final GameResultParser gameResultParser = new GameResultParser();
    public String getGameId(String s) { return gameResultParser.returnGameId(s); }
    public boolean exceedsMaximumCubes(String s) { return gameResultParser.isLessThanAllowedMax(s); }

    public int returnTotalIds(Supplier<Stream<String>> dataSupplier) {
        return calulcateTotalIds(dataSupplier.get());
    }

    public int returnTotalIds(String... inputData) {
        return calulcateTotalIds(Arrays.stream(inputData));
    }

    private int calulcateTotalIds(Stream<String> stringStream) {
        int totalOfGameIDs = 0;

        List<String> validGames = getStrings(stringStream);

        for (String game : validGames) {
            totalOfGameIDs += Integer.parseInt(getGameId(game));
        }
        return totalOfGameIDs;
    }

    private List<String> getStrings(Stream<String> stringStream) {
        return stringStream
                .filter(this::exceedsMaximumCubes)
                .toList();
    }
}
