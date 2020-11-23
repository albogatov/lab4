package moumie;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BoatTest {
	private Boat boat;
	private Boat boat2;
	private Child owner;
	private Child owner2;
	private Sand sand;
	@Test
	public void initiateTest() throws BoatDestructionException {
		owner = new Child("Ребенок", State.EXISTS, Location.BEACH, 10, "Ж");
		owner2 = new Child("Ребенок", State.EXISTS, Location.BEACH, 1, "Ж");
		sand = new Sand("Песок", State.IS_WET, Location.BEACH);
		boat = new Boat("Лодка", State.EXISTS, Location.WATER, owner);
		boat2 = new Boat("Лодка", State.EXISTS, Location.WATER, owner2);
		boat.bumpInto(sand);
		assertEquals(boat.getDamage(), 0);
		boat2.bumpInto(sand);
		assertEquals(boat2.getDamage(), 2);
	}
}