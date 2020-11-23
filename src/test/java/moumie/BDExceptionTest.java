package moumie;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BDExceptionTest {
	@Test
	public void initiateTest() {
		Child child = new Child("Ребенок", State.EXISTS, Location.BEACH, 1, "Ж");
		Shallow sh = new Shallow("Отмель");
		assertThrows(BoatDestructionException.class, () -> { child.maneuverAround(sh, new Destructible () {
				private int damage;
				public void increaseDamage(int i) {
					this.damage = this.damage + i;
				}
				public int getDamage() {
					return this.damage;
				}
			});
		});
	}
}