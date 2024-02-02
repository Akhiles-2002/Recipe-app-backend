
package in.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.model.Receipe;
import in.com.model.User;
import in.com.service.ReceipeService;
import in.com.service.UserService;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

	@Autowired
	private ReceipeService receipeService;

	@Autowired
	private UserService userService;

	@PostMapping()
	public Receipe createReceipe(@RequestBody Receipe receipe, @RequestHeader("Authorization") String jwt)
			throws Exception {
		User user = userService.findUserByJwt(jwt);
		Receipe createdReceipe = receipeService.createReceipe(receipe, user);
		return createdReceipe;
	}

	@GetMapping()
	public List<Receipe> getAllReceipes() {
		return receipeService.findAllReceipes();
	}

	public Receipe findReceipeById(Long receipeId) throws Exception {
		return receipeService.findReceipeById(receipeId);
	}

	@DeleteMapping("/{receipeId}")
	public String deleteReceipe(@PathVariable("receipeId") Long receipeId) throws Exception {
		return receipeService.deleteReceipe(receipeId);
	}

	@PutMapping("/{receipeId}")
	public Receipe updateReceipe(@RequestBody Receipe receipe, @PathVariable Long receipeId) throws Exception {
		return receipeService.updateReceipe(receipe, receipeId);
	}

	@PutMapping("/{receipeId}/like")
	public Receipe likeReceipe(@PathVariable("receipeId") Long receipeId, @RequestHeader("Authorization") String jwt)
			throws Exception {
		User user = userService.findUserByJwt(jwt);
		return receipeService.likeReceipe(receipeId, user);
	}

}
