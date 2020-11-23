package moumie;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ChildTest {
	private Child child; 
	@Test
	public void initiateTest() {
		child = new Child("Ребенок", State.EXISTS, Location.BEACH, 10, "Ж");
		assertEquals(child.getName(), "Ребенок");
		assertEquals(child.getState(), State.EXISTS);
		assertEquals(child.getLocation(), Location.BEACH);
		assertEquals(child.getSkill(), 10);
		assertEquals(child.getGender(), "Ж");
		assertTrue(child.isSuccessful());
	}
	@Test
	public void initiateTest2() {
		child = new Child("Ребенок1", State.ACTIVE, Location.BOAT, 5, "М");
		assertEquals(child.getName(), "Ребенок1");
		assertEquals(child.getState(), State.ACTIVE);
		assertEquals(child.getLocation(), Location.BOAT);
		assertEquals(child.getSkill(), 5);
		assertEquals(child.getGender(), "М");
		assertFalse(child.isSuccessful());
		child.jumpOut(Location.BEACH);
		assertEquals(child.getLocation(), Location.BEACH);
	}
}