package moumie;
public interface Inanimate {
	void setOwner(LivingBeing owner);
	LivingBeing getOwner();
	String showOwner();
	void setDefinition(String def);
	String getDefinition();
}