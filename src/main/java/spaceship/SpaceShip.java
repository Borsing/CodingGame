package spaceship;

import static spaceship.EnemySpaceShip.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SpaceShip {

	private final int shieldStrength;

	private final Map<EnemySpaceShipType, Integer> damagePerShip;

	/**
	 * Your beam deals the damage value in damagePerShip map. The actual damage that the spaceship receives is decreased by the spaceship's ARMOR. Your antimatter beam always deals at least
	 * 1 damage, even if the target spaceship's ARMOR is greater than your beam's damage.
	 *
	 * @param enemySpaceShip to attack
	 */
	private int damageEnemyPerTurn(EnemySpaceShip enemySpaceShip) {
		return Math.max(1, damagePerShip.get(enemySpaceShip.getType()) - enemySpaceShip.getArmor());
	}

	/**
	 * Count the number of turn to destroy an enemy spaceship.
	 */
	private int turnsToDestroy(EnemySpaceShip enemySpaceShip) {
		return (int) Math.ceil((double) enemySpaceShip.getHp() / (double) this.damageEnemyPerTurn(enemySpaceShip));
	}

	/**
	 * We choose to kill enemy1 compare to enemy2 dealing with the total damage received if we fight first enemy1 then enemy2 or first enemy2 then enemy1. The dangerousness of an enemy is
	 * defined by the total damage received if we let him alive while we kill the other enemy.
	 */
	private int compareByDangerousness(EnemySpaceShip enemy1, EnemySpaceShip enemy2) {
		int turnToDestroyEnemy1 = turnsToDestroy(enemy1);
		int turnToDestroyEnemy2 = turnsToDestroy(enemy2);

		//damageReceived (dangerousness) if kill first enemy1 then enemy2
		int dangerousnessEnemy2 = (enemy1.getDamage() + enemy2.getDamage()) * turnToDestroyEnemy1 + enemy2.getDamage() * turnToDestroyEnemy2;
		//damageReceived (dangerousness) if kill first enemy2 then enemy1
		int dangerousnessEnemy1 = (enemy1.getDamage() + enemy2.getDamage()) * turnToDestroyEnemy2 + enemy1.getDamage() * turnToDestroyEnemy1;

		//we compare with the most dangerousness on top.
		return Integer.compare(dangerousnessEnemy2, dangerousnessEnemy1);
	}

	/**
	 * Story : <br/> Predict the fight against the enemySpaceShips. «Story» Your spaceship is under attack by aliens! (It's actually your friend's spaceship, so the situation is even worse)
	 * Luckily your spaceship is equipped with an antimatter beam, while the aliens only have cheap (but still dangerous) laser pointers. Can you destroy all alien spaceships safely, or
	 * should you flee?
	 * <p>
	 * Prompt : <br/> As the AI within the ship's computer, your goal is to determine the optimal order of alien spaceships to destroy such that you leave the encounter with the maximum
	 * strength of your shields. Print the remaining strength of the shields, or -1 if your spaceship is predicted to take more damage than your shields can handle. Your friend will not
	 * forgive you if the ship is damaged.
	 * <p>
	 * Details : <br/> The encounter can be modeled by turn-based combat. Your spaceship's shields begin with its strengthShield. You are fighting against N alien spaceships of various
	 * properties. These properties are:
	 * <ul>
	 *     <li> TYPE - the type of the spaceship, which can be either FIGHTER or CRUISER</li>
	 *     <li> HP - the amount of damage the spaceship can receive before being destroyed</li>
	 *     <li> ARMOR - the damage reduction of the spaceship</li>
	 *     <li> DAMAGE - the amount of damage the spaceship deals per turn.</li>
	 * </ul>
	 * <p>
	 * On each turn, all alien spaceships reduce your ship's shields by DAMAGE as your antimatter beam charges, and then one spaceship takes damage from your antimatter beam.
	 * Your beam deals the damage value in damagePerShip map. The actual damage that the spaceship receives is decreased by the spaceship's ARMOR.
	 * Your antimatter beam always deals at least 1 damage, even if the target spaceship's ARMOR is greater than your beam's damage.
	 *
	 * @param enemySpaceShips list of all the spaceships to fight.
	 * @return if the fight is lose return -1, otherwise return the hp expected of the spaceship after the fight.
	 */
	public int predictFight(List<EnemySpaceShip> enemySpaceShips) {
		//Sort enemies by dangerousness (the most dangerous first)
		List<EnemySpaceShip> enemySpaceShipByDangerousness = enemySpaceShips.stream()
				.sorted(this::compareByDangerousness)
				.collect(Collectors.toList());

		//Unfold the fight
		int totalDamageReceived = 0;
		List<EnemySpaceShip> remainingEnemies = new LinkedList<>(enemySpaceShipByDangerousness);

		for (EnemySpaceShip currentEnemy : enemySpaceShipByDangerousness) {
			final int turnToDestroyCurrent = this.turnsToDestroy(currentEnemy);
			totalDamageReceived += remainingEnemies.stream()
					.mapToInt(remainingEnemy -> turnToDestroyCurrent * remainingEnemy.getDamage())
					.sum();
			remainingEnemies.remove(currentEnemy);
		}

		//return the hp remaining of the space ship or -1 if it is lose.
		return Math.max(-1, this.shieldStrength - totalDamageReceived);
	}
}
