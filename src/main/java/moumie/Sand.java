package moumie;

public final class Sand extends Thing {
	public Sand(String def, State state, Location loc) {
		setDefinition(def);
		setState(state);
		setLocation(loc);
	}
}