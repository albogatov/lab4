package moumie;

public final class Tablecloth extends Thing {
	public Tablecloth(String def, State state, LivingBeing owner) {
		setDefinition(def);
		setState(state);
		setOwner(owner);
		setLocation(owner.getLocation());
	}
	public static class Surface {
		private static int itemCount = 0;
		public static void changeItemCount(int i) {
			itemCount = itemCount + i;
		}
		public static int getItemCount() {
			return itemCount;
		}
	}
}