package moumie;

public class Main {
	public static void main(String[] args) throws BoatDestructionException, NotEnoughItemsException {
		Wind wind = new Wind("Ветер", State.BLOWING, Location.BEACH);
		Parent mom = new Parent("Муми-мама", State.EXISTS, Location.BOAT, "Ж");
		Child son = new Child("Муми-тролль", State.EXISTS, Location.BOAT, 10, "М");
		Shallow sh1 = new Shallow("Отмель");
		Shallow sh2 = new Shallow("Отмель");
		Shallow sh3 = new Shallow("Отмель");
		Sand sand = new Sand("Песок", State.IS_WET, Location.BEACH);
		Boat boat = new Boat("Лодка", State.EXISTS, Location.WATER, son); 
		Falin falin = new Falin("Фалинь", State.EXISTS, son);
		Rock rocks = new Rock("Камень", State.EXISTS, Location.BEACH, 10);
		Pancakes food = new Pancakes("Оладьи", State.COLD, mom);
		Logs logs = new Logs("Дрова", State.EXISTS, Location.BEACH);
		Tablecloth cloth = new Tablecloth("Скатерть", State.FOLDED, mom);
		Cups cups = new Cups("Чашки", State.EXISTS, mom);
		CanOfButter can = new CanOfButter("Банка с маслом", State.EXISTS, mom);
		Cliff cl = new Cliff("Скала", State.EXISTS, Location.BEACH);
		CliffShadow shadow = new CliffShadow("Тень скалы", State.EXISTS);
		shadow.cover(sand);
		Lillies lillies = new Lillies("Лилии", State.EXISTS, Location.BEACH);
		Table table = new Table("Стол", State.EXISTS, mom);
		LivingBeing.Look(2, Location.OUTSIDE_BOAT);
		try {
			son.maneuverAround(sh1, boat);
			boat.noseBumpInto(sand);
			son.holdOnTo(falin);
			son.jumpOut(Location.BEACH);
			mom.switchLocation(Location.BEACH);
			if(Location.BEACH.getInhabitants()>=2) {
				Location.BEACH.setState(State.ACTIVE);
				mom.setState(State.HURRY);
				son.setState(State.HURRY);
				System.out.println("Обитатели берега суетятся");
				Location.BEACH.showState();
			}
			mom.pickUpRocks(rocks, 12);
			mom.createFireplace();
			mom.pickUp(logs);
			mom.place(cloth, sand);
			if(mom.getItemCount() >= 4) {
				int i = mom.getItemCount();
				while(Tablecloth.Surface.getItemCount() < 4) {
					mom.place(rocks, cloth);
				}
			}
			else {
				mom.pickUpRocks(rocks, 4);
				if(mom.getItemCount() < 4) {
					throw new NotEnoughItemsException("Недостаточно предметов");
				}
				int i = mom.getItemCount();
				while(mom.getItemCount() > i - 4) {
					mom.place(rocks, cloth);
				}
			}
			mom.place(cups, cloth);
			mom.bury(can, sand);
			mom.pickUp(lillies);
			mom.place(lillies, table);
		} catch(BoatDestructionException|NotEnoughItemsException e) {
			
			throw new StoryNotFinishedException("История не может быть завершена", e);
		}
	}
}