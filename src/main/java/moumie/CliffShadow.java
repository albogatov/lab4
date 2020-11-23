package moumie;

public final class CliffShadow extends Cliff {
	public CliffShadow(String def, State state) {
		setDefinition(def);
		setState(state);
		setLocation(super.getLocation());
	}
	public void cover(Thing thing) {
		System.out.println(getDefinition() + " покрывает " + thing.getDefinition());
	}
}