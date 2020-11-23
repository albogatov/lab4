package moumie;

public final class Falin extends Thing {
	public Falin(String def, State state, LivingBeing owner) {
		setDefinition(def);
		setState(state);
		setOwner(owner);
		setLocation(owner.getLocation());
	}
}