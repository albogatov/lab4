package moumie;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NEIExceptionTest {
	@Test
	public void initiateTest() throws NotEnoughItemsException {
		Parent parent = new Parent("Отец", State.ACTIVE, Location.BEACH, "М");
		Rock rocks = new Rock("Камень", State.EXISTS, Location.BEACH, 10);
		parent.pickUpRocks(rocks, 5);
		assertThrows(NotEnoughItemsException.class, () -> { parent.createFireplace(); });
		parent.pickUpRocks(rocks, 1);
		parent.createFireplace();
		assertEquals(parent.getItemCount(), 0);
	}
}