package moumie;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParentTest {
	private Parent parent; 
	@Test
	public void initiateTest() {
		parent = new Parent("Мать", State.EXISTS, Location.BEACH, "Ж");
		assertEquals(parent.getName(), "Мать");
		assertEquals(parent.getState(), State.EXISTS);
		assertEquals(parent.getLocation(), Location.BEACH);
		assertEquals(parent.getGender(), "Ж");
	}
	@Test
	public void initiateTest2() {
		parent = new Parent("Отец", State.ACTIVE, Location.BEACH, "М");
		assertEquals(parent.getName(), "Отец");
		assertEquals(parent.getState(), State.ACTIVE);
		assertEquals(parent.getLocation(), Location.BEACH);
		assertEquals(parent.getGender(), "М");
	}
	@Test
	public void itemCollectionTest() {
		class TestRock extends Rock {
			private int testCount;
			private int testItems[] = new int[testCount];
			public TestRock(int testCount) {
				this.testItems = new int[testCount];
				for (this.testCount = 0; this.testCount < testCount; this.testCount++) {
					this.testItems[this.testCount] = 1;
				}
			}
			public int getCount() {
				return this.testCount;
			}
			public void setItem(int i, int j) {
				this.testItems[i] = j;
			}
			public int getItem(int i) {
				return this.testItems[i];
			}
			public TestRock() {
				
			}
		}
		class TestParent extends Parent {
			public void pickUpRocks(TestRock thing, int number) {
				if(getItemCount() == 0)
					System.out.println(getName() + " подбирает несколько " + thing.getDefinition());

					int i;
					for(i = 0; i < thing.getCount(); i++) {
						if(thing.getItem(i) == 1) {
							thing.setItem(i, 0);
							changeItemCount(1);
						}
						if(getItemCount() == number) {
							break;
						}
					}
				
				thing.setOwner(this);
			}
		}
		TestRock rock = new TestRock(10);
		assertEquals(rock.getItem(9), 1);
		TestParent parent1 = new TestParent();
		parent1.pickUpRocks(rock, 5);
		assertEquals(parent1.getItemCount(), 5);
		parent1.changeItemCount(1);
		assertEquals(parent1.getItemCount(), 6);
		parent1.changeItemCount(-1);
		assertEquals(parent1.getItemCount(), 5);
		parent1.pickUp(new TestRock());
		assertEquals(parent1.getItemCount(), 5);
	}
	@Test
	public void purposeTest() {
		parent = new Parent("Мать", State.EXISTS, Location.BEACH, "Ж");
		parent.setPurpose("test");
		assertEquals(parent.getPurpose(), "test");
	}
}