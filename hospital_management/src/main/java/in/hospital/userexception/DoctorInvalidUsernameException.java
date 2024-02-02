package in.hospital.userexception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DoctorInvalidUsernameException extends Exception {

	public DoctorInvalidUsernameException(String message) {
		this.message = message;
	}

	private static final long serialVersionUID = 1L;

	private String message;

}
