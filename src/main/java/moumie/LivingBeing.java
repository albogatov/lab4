package moumie;
import java.util.Objects;

public abstract class LivingBeing implements Interactable, Animate {
	private String name;
	private State state;
	private Location loc = null;
	private String gender;
	private static int exist;
	public void setGender(String g) {
		this.gender = g;
	}
	public String getGender() {
		return this.gender;
	}
	public static void increaseNumber() {
		LivingBeing.exist = LivingBeing.exist+1;
	}
	public static int getNumber() {
		return LivingBeing.exist;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return this.name;
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
		if(this.loc != null) {
			this.loc.changeInhabitants(-1);
		}
		this.loc = loc;
		this.loc.changeInhabitants(1);
		
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
		return Objects.hash(name, state, loc);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() != this.getClass())
			return false;
		if(this == obj)
			return true;
		LivingBeing other = (LivingBeing) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return ("Живое существо по имени " + getName());
	}
	static void Look(int i, Location loc) {
		if(i<LivingBeing.getNumber())
			System.out.println("Некоторые посмотрели " + loc.toString());
		if(i==LivingBeing.getNumber()) {
			System.out.println("Все посмотрели " + loc.toString());
		}
	}
	public boolean isSuccessful() {
		return true;
	}
	public void exitLocation(Location loc) {
		this.loc.changeInhabitants(-1);
		setLocation(loc);
		this.loc.changeInhabitants(1);
	}
	public void switchLocation(Location loc) {
		System.out.println(getName() + " перешел из " + this.showLocation() + " в " + loc.toString());
		exitLocation(loc);
	}
	public void holdOnTo(Thing thing) {
		if(thing.getOwner().equals(this)) {
			System.out.println(getName() + " держит " + thing.getDefinition());
			thing.setState(State.HELD_BY_OWNER);
		}
	}
}