package adventofcode.day2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CubeChecker {
    private final GameResultParser gameResultParser = new GameResultParser();
    private final CubeLimitChecker cubeLimitChecker = new CubeLimitChecker();
    private static final CubePowerChecker CUBE_POWER_CHECKER = new CubePowerChecker();

    public String getGameId(String s) { return gameResultParser.returnGameId(s); }
    public boolean exceedsMaximumCubes(String s) { return cubeLimitChecker.isLessThanAllowedMax(s); }

    public int returnTotalValidIds(Supplier<Stream<String>> dataSupplier) { return calulcateTotalValidIds(dataSupplier.get()); }
    public int returnTotalValidIds(String... inputData) {
        return calulcateTotalValidIds(Arrays.stream(inputData));
    }


    public int returnPowerOfMinimumCubes(Supplier<Stream<String>> dataSupplier) { return calculatePowerOfMinimumCubes(dataSupplier.get()); }
    public int returnPowerOfMinimumCubes(String... inputData) { return calculatePowerOfMinimumCubes(Arrays.stream(inputData)); }

    private int calulcateTotalValidIds(Stream<String> stringStream) {
        int totalOfGameIDs = 0;

        List<String> validGames = addValidGamesToList(stringStream);

        for (String game : validGames) {
            totalOfGameIDs += Integer.parseInt(getGameId(game));
        }
        return totalOfGameIDs;
    }

    private int calculatePowerOfMinimumCubes(Stream<String> stringStream) {
        int totalPower = 0;

        List<String> allPowersOfCubes = stringStream.toList();

        for (String powerOfGame : allPowersOfCubes) {
           totalPower += CUBE_POWER_CHECKER.returnMinCubesMultiplied(powerOfGame);
        }

        return totalPower;
    }

    private List<String> addValidGamesToList(Stream<String> stringStream) {
        return stringStream
                .filter(this::exceedsMaximumCubes)
                .toList();
    }
}
