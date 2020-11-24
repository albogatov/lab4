package moumie;
public final class Child extends Parent {
	private int skill;
	public void setSkill(int i) {
		this.skill = this.skill + i;
	}
	public int getSkill() {
		return this.skill;
	}
	public Child(String name, State state, Thing locObj, int i, String g) {
		setName(name);
		setState(state);
		setLocation(locObj);
		setSkill(i);
		setGender(g);
		super.increaseNumber();
	}
	public Child(String name, State state, Location loc, int i, String g) {
		setName(name);
		setState(state);
		setLocation(loc);
		setSkill(i);
		setGender(g);
		super.increaseNumber();
	}
	public boolean isSuccessful() {
		if(getSkill()>=10) {
				return true;
		}
		else return false;
	}
	public void maneuverAround(Thing thing, Destructible destrcuctible) throws BoatDestructionException {
		if(thing.toString().equals("Отмель")) {
			if(isSuccessful()) {
				if(getGender().equals("М"))
					System.out.println(getName() + " изящно обошел " + thing.toString());
				else
					System.out.println(getName() + " изящно обошла " + thing.toString());
			}
			else {
				if(getGender().equals("М"))
					System.out.println(getName() + " не сумел обойти " + thing.toString());
				else
					System.out.println(getName() + " не сумела обойти " + thing.toString());
				destrcuctible.increaseDamage(10);
				if(destrcuctible.getDamage()>=10) {
					throw new BoatDestructionException("Лодка разбилась");
				}
			}
		}
	}
	public void jumpOutObj(Location loc) {
		if(getGender().equals("М"))
			System.out.println(getName() + " выпрыгнул из " + this.showObjLocation() + " на " + loc.toString());
		else
			System.out.println(getName() + " выпрыгнула из " + this.showObjLocation() + " на " + loc.toString());
		exitLocation(loc);
	}
	public void jumpOut(Location loc) {
		if(getGender().equals("М"))
			System.out.println(getName() + " выпрыгнул из " + this.showLocation() + " на " + loc.toString());
		else
			System.out.println(getName() + " выпрыгнула из " + this.showLocation() + " на " + loc.toString());
		exitLocation(loc);
	}
}