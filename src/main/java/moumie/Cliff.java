package moumie;

public class Cliff extends Thing {
	public Cliff() {
		
	}
	public Cliff(String def, State state, Location loc) {
		setDefinition(def);
		setState(state);
		setLocation(loc);
	}
}