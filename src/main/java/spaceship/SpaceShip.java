package spaceship;

import static spaceship.EnemySpaceShip.EnemySpaceShipType;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SpaceShip {

	private final int shieldStrength;

	private final Map<EnemySpaceShipType, Integer> damagePerShip;

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
		return -1;
	}
}
