package moumie;

public class Rock extends Thing {
	private int count;
	private int[] items = new int[count];
	public int getCount() {
		return this.count;
	}
	public void setItem(int i, int j) {
		this.items[i] = j;
	}
	public int getItem(int i) {
		return this.items[i];
	}
	public Rock(String def, State state, Location loc, int count) {
		setDefinition(def);
		setState(state);
		setLocation(loc);
		this.items = new int[count];
		for (this.count = 0; this.count < count; this.count++) {
			this.items[this.count] = 1;
		}
	}
	public Rock() {
		
	}
}