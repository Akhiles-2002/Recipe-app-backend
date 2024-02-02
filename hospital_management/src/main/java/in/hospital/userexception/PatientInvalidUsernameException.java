package in.hospital.userexception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PatientInvalidUsernameException extends Exception {

	public PatientInvalidUsernameException(String message) {
		this.message = message;
	}

	private static final long serialVersionUID = 1L;

	private String message;

}
