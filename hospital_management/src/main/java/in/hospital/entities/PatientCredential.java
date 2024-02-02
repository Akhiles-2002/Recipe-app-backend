package in.hospital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PatientCredentials")
public class PatientCredential {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long credentialId;
	private String username;
	private String password;
	
	public Long getCredentialId() {
		return credentialId;
	}
	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Patient patient;

}
