package moumie;

public final class Boat extends Thing implements Destructible {
	private int damage = 0;
	private BoatNose nose;
	public void increaseDamage(int i) {
		this.damage = this.damage + i;
	}
	public int getDamage() {
		return this.damage;
	}
	public Boat(String def, State state, Location loc, LivingBeing owner) {
		setDefinition(def);
		setState(state);
		setLocation(loc);
		setOwner(owner);
		nose = new BoatNose();
	}
	public Boat() {
		
	}
	public class BoatNose {
		private final String partDef = "Нос лодки";
		public BoatNose() {
			
		}
		public void bumpInto(Thing thing) throws BoatDestructionException {
			System.out.print("Носом ");
			Boat.this.bumpInto(thing);
		}
	}
	public void bumpInto(Thing thing) throws BoatDestructionException {
		if(thing.toString().equals("Песок")) {
			if(getOwner().isSuccessful()) {
				System.out.println("Лодка мягко уткнулась в " + thing.toString());
			}
			else {
				System.out.println("Лодка врезалась в " + thing.toString());
				increaseDamage(2);
				if(getDamage()>=10) {
					throw new BoatDestructionException("Лодка разбилась");
				}
			}
		}
	}
	public void noseBumpInto(Thing thing) throws BoatDestructionException {
		BoatNose nose = new BoatNose();
		nose.bumpInto(thing);
	}
} 