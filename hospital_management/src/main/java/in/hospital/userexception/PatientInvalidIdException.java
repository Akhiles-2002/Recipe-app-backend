package in.hospital.userexception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PatientInvalidIdException extends Exception {

	public PatientInvalidIdException(String message) {
		this.message = message;
	}

	private static final long serialVersionUID = 1L;

	private String message;

}
