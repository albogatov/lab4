package moumie;

public final class Wind extends Thing {
	public Wind(String def, State state, Location loc) {
		setDefinition(def);
		setState(state);
		setLocation(loc);
	}
}