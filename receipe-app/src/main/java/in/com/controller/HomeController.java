package in.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String homeController() {
		return "Welcome in Receipe Management App!...";
	}
	
}
