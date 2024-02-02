package in.com.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Receipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long receipeId;
	private String receipeTitle;
	private String image;
	private String description;
	private boolean vegetarian;

	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt = LocalDateTime.now();
//	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//	String formatDateTime = createdAt.format(format);
//	String formatDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

	@ManyToOne
	private User user;

	private List<Long> likes = new ArrayList<>();

}
