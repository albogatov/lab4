package moumie;

public enum State {
	EXISTS("Существует"),
	IS_WET("Влажный"),
	HELD_BY_OWNER("В руках у владельца"),
	ACTIVE("Ожил"),
	COLD("Холодный"),
	FOLDED("Сложенный"),
	UNFOLDED("Расстелена"),
	BLOWING("Дует"),
	HURRY("Суетится");
	
	private String description;
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	State(String description) {
		setDescription(description);
	}
	
	@Override
	public String toString() {
		return this.description;
	}
}