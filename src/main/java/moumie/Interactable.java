package moumie;
public interface Interactable {
	void setState(State state);
	State getState();
	String showState();
	void setLocation(Location loc);
	Location getLocation();
	String showLocation();
}