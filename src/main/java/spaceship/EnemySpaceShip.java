package spaceship;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class EnemySpaceShip {

	final EnemySpaceShipType type;
	final int armor;
	final int damage;
	int hp;

	public enum EnemySpaceShipType {
		FIGHTER, CRUISER
	}
}
