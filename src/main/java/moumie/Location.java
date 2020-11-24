package moumie;
public enum Location {
	WATER("Вода", 0, State.EXISTS),
	BEACH("Берег", 0, State.EXISTS);
	
	private String description;
	private int inhabitants;
	private State state;
	
	public void setState(State state) {
		this.state = state;
	}
	public State getState() {
		return this.state;
	}
	public void showState() {
		System.out.println(toString() + " " + this.getState().toString());
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setInhabitants(int inhabitants) {
		this.inhabitants = inhabitants;
	}
	public int getInhabitants() {
		return this.inhabitants;
	}
	public void changeInhabitants(int i) {
		this.inhabitants = inhabitants + i;
	}
	Location(String description, int inhabitants, State state) {
		setDescription(description);
		setInhabitants(inhabitants);
		setState(state);
	}
	
	@Override
	public String toString() {
		return this.description;
	}
}