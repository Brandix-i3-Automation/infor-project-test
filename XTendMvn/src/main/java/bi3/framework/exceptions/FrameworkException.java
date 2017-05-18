package bi3.framework.exceptions;

/**
 * The Class FrameworkException.
 */
public class FrameworkException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4968561865392444211L;

	/**
     * Instantiates a new framework exception.
     *
     * @param message the message
     */
    public FrameworkException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new framework exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public FrameworkException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
