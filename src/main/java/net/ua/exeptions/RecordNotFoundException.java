package net.ua.exeptions;

/**
 * @author Alexander Eveler
 */
public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 7912430463119133286L;

	public RecordNotFoundException() {
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public RecordNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public RecordNotFoundException(String message, Throwable throwable, boolean arg2, boolean arg3) {
        super(message, throwable, arg2, arg3);
    }
}
