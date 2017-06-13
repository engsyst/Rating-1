package ua.nure.indplan.exeptions;

public class StorageException extends RuntimeException {

	private static final long serialVersionUID = -7055676502303563705L;

	public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
