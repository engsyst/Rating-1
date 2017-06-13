package ua.nure.indplan.exeptions;

public class StorageFileNotFoundException extends StorageException {

	private static final long serialVersionUID = -6199279894870556278L;

	public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}