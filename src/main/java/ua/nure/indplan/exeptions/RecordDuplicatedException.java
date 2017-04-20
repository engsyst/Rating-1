package ua.nure.indplan.exeptions;

/**
 * @author Alexander Eveler
 */
public class RecordDuplicatedException extends Exception {

	private static final long serialVersionUID = 3091290083830667206L;

	public RecordDuplicatedException() {
    }

    public RecordDuplicatedException(String message) {
        super(message);
    }

    public RecordDuplicatedException(Throwable throwable) {
        super(throwable);
    }

    public RecordDuplicatedException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public RecordDuplicatedException(String message, Throwable throwable, boolean arg2, boolean arg3) {
        super(message, throwable, arg2, arg3);
    }
}
