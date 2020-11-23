package moumie;

public final class Pancakes extends Thing {
	public Pancakes(String def, State state, LivingBeing owner) {
		setDefinition(def);
		setState(state);
		setOwner(owner);
		setLocation(owner.getLocation());
	}
}