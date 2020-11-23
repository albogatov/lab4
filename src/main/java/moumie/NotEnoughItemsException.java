package moumie;

public final class NotEnoughItemsException extends Exception {
	String message;
	public NotEnoughItemsException(String description) {
		message = description;
	}
	@Override
	public String getMessage() {
		return message;
	}
}