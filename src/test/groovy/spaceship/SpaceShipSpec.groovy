package spaceship

import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

import static spaceship.EnemySpaceShip.EnemySpaceShipType
import static spaceship.EnemySpaceShip.EnemySpaceShipType.CRUISER
import static spaceship.EnemySpaceShip.EnemySpaceShipType.FIGHTER
import static spaceship.EnemySpaceShip.builder

class SpaceShipSpec extends Specification {

    @Unroll
    void "Test SpaceShip.predictFight given list of Enemies space ship #testCase"() {
        given: "Initialize enemySpaceShips and my spaceship"
        def enemySpaceShips = getSampleSetEnemySpaceShip(testCase)

        SpaceShip mySpaceShip = SpaceShip.builder()
                .shieldStrength(5000)
                .damagePerShip(Map.of(CRUISER, 10, FIGHTER, 20))
                .build()

        when: "Predict the fight"
        def lastHp = mySpaceShip.predictFight(enemySpaceShips)

        then: "lastHp of mySpaceShip should be #expectedLastHp"
        lastHp == expectedLastHp

        where: "my data are in the file #test_case"
        testCase | expectedLastHp
        1        | 3200
        2        | 1700
        3        | 2880
        4        | 3430
        5        | 212
        6        | -1
        7        | 0
        8        | 4950
    }

    /**
     * Parse the file in src/test/resources/spaceship/test_case<testCase>.txt and return a list of EnemySpaceShip
     * @param testCase index of the file parsed.
     */
    private static List<EnemySpaceShip> getSampleSetEnemySpaceShip(int testCase) {
        return Files.lines(Paths.get("src/test/resources/spaceship/test_case${testCase}.txt"))
                .filter({ !it.empty })
                .map({ it.split(" ") })
                .map({
                    builder()
                            .type(EnemySpaceShipType.valueOf(it[0]))
                            .hp(Integer.valueOf(it[1]))
                            .armor(Integer.valueOf(it[2]))
                            .damage(Integer.valueOf(it[3]))
                            .build()
                })
                .collect(Collectors.toList())
    }
}

