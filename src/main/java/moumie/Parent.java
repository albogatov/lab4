package moumie;
public class Parent extends LivingBeing {
	private int itemCount;
	private String purpose;
	public void setPurpose(String p) {
		this.purpose = p;
	}
	public String getPurpose() {
		return this.purpose;
	}
	public void showPurpose() {
		System.out.println(this.getName() + " хочет " + this.purpose);
	}
	public void changeItemCount(int i) {
		this.itemCount = this.itemCount + i;
	}
	public int getItemCount() {
		return this.itemCount;
	}
	public Parent() {
		
	}
	public Parent(String name, State state, Location loc, String g) {
		setName(name);
		setState(state);
		setLocation(loc);
		setGender(g);
		super.increaseNumber();
	}
	public void pickUpRocks(Rock thing, int number) {
		if(getItemCount() == 0)
			System.out.println(getName() + " подбирает несколько " + thing.getDefinition());
		if(thing.toString().equals("Камень")) {
			int i;
			int j = getItemCount();
			for(i = 0; i < thing.getCount(); i++) {
				if(thing.getItem(i) == 1) {
					thing.setItem(i, 0);
					changeItemCount(1);
				}
				if(getItemCount() == j + number) {
					break;
				}
			}
		}
		thing.setOwner(this);
	}
	public void pickUp(Thing thing) {
		thing.setOwner(this);
		System.out.println(getName() + " подбирает " + thing.getDefinition());
	}
	public void place(Thing thing, Thing spot) {
		if(getGender().equals("Ж"))
			System.out.println(getName() + " поместила " + thing.getDefinition() + " на " + spot.getDefinition());
		else 
			System.out.println(getName() + " поместил " + thing.getDefinition() + " на " + spot.getDefinition());
		thing.setLocation(spot.getLocation());
		if(thing.toString().equals("Камень")) {
			changeItemCount(-1);
		}
		if(thing.toString().equals("Скатерть")) {
			thing.setState(State.UNFOLDED);
			System.out.println(thing.toString() + " " + thing.showState());
		}
		if(spot.toString().equals("Скатерть")) {
			Tablecloth.Surface.changeItemCount(1);
		}
	}
	public void bury(Thing thing, Thing spot) {
		if(getGender().equals("Ж"))
			System.out.println(getName() + " закопала " + thing.getDefinition() + " в " + spot.getDefinition());
		else 
			System.out.println(getName() + " закопал " + thing.getDefinition() + " в " + spot.getDefinition());
		thing.setLocation(spot.getLocation());
	}
	public void createFireplace() throws NotEnoughItemsException {
		if(getItemCount() < 6) {
			throw new NotEnoughItemsException("Недостаточно предметов");
		}
		else {
			changeItemCount(-6);
			if(getItemCount() < 0) {
				//System.out.println("Недостаточно камней");
				changeItemCount(6);
				throw new NotEnoughItemsException("Недостаточно камней");
			}
			else {
				Fireplace fireplace = new Fireplace("очаг", State.EXISTS, this.getLocation(), this);
				if(getGender().equals("Ж"))
					System.out.println(getName() + " сложила " + fireplace.getDefinition());
				else
					System.out.println(getName() + " сложил " + fireplace.getDefinition());
				setPurpose("подогреть оладьи");
				showPurpose();
			}
		}
	} 
	
}