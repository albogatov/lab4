package moumie;
import java.util.Objects;

public abstract class Thing implements Interactable, Inanimate{
	private State state;
	private Location loc;
	private String def;
	private LivingBeing owner;
	@Override
	public void setOwner(LivingBeing owner) {
		this.owner = owner;
	}
	@Override
	public LivingBeing getOwner() {
		return this.owner;
	}
	@Override
	public String showOwner() {
		return this.owner.toString();
	}
	@Override
	public void setDefinition(String def) {
		this.def = def;
	}
	@Override
	public String getDefinition() {
		return this.def;
	}
	@Override
	public void setState(State state) {
		this.state = state;
	}
	@Override
	public State getState() {
		return this.state;
	}
	@Override
	public String showState() {
		return this.state.toString();
	}
	@Override
	public void setLocation(Location loc) {
		this.loc = loc;
	}
	@Override
	public Location getLocation() {
		return this.loc;
	}
	@Override
	public String showLocation() {
		return this.loc.toString();
	}
	@Override
	public int hashCode() {
		return Objects.hash(def, state, loc);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() != this.getClass())
			return false;
		if(this == obj)
			return true;
		Thing other = (Thing) obj;
		return Objects.equals(def, other.def);
	}
	@Override
	public String toString() {
		return getDefinition();
	}
}