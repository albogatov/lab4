package moumie;

public final class Table extends Thing {
	public Table(String def, State state, LivingBeing owner) {
		setDefinition(def);
		setState(state);
		setOwner(owner);
		setLocation(owner.getLocation());
	}
}