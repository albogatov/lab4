package moumie;

public final class CanOfButter extends Thing {
	public CanOfButter(String def, State state, LivingBeing owner) {
		setDefinition(def);
		setState(state);
		setOwner(owner);
		setLocation(owner.getLocation());
	}
}