package moumie;

public final class Fireplace extends Thing {
	public Fireplace(String def, State state, Location loc, LivingBeing owner) {
		setDefinition(def);
		setState(state);
		setLocation(loc);
		setOwner(owner);
	}
}