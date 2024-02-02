package in.hospital.userexception;

public class AdminInvalidPasswordException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public AdminInvalidPasswordException() {
		this.message = "Invalid Password";
	}

	public AdminInvalidPasswordException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
