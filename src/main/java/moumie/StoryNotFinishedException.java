package moumie;

public final class StoryNotFinishedException extends RuntimeException {
	public StoryNotFinishedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}