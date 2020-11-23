package moumie;

public final class BoatDestructionException extends Exception {
	String message;
	public BoatDestructionException(String description) {
		message = description;
	}
	@Override
	public String getMessage() {
		return message;
	}
}