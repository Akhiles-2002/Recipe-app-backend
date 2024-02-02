package in.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.model.Receipe;
import in.com.model.User;
import in.com.repository.ReceipeRepository;

@Service
public class ReceipeServiceImpl implements ReceipeService {

	@Autowired
	private ReceipeRepository receipeRepository;

	@Override
	public Receipe createReceipe(Receipe receipe, User user) {
		Receipe createdReceipe = new Receipe();
		createdReceipe.setReceipeTitle(receipe.getReceipeTitle());
		createdReceipe.setImage(receipe.getImage());
		createdReceipe.setDescription(receipe.getDescription());
		createdReceipe.setUser(user);
		createdReceipe.setCreatedAt(receipe.getCreatedAt());
		return receipeRepository.save(createdReceipe);
	}

	@Override
	public Receipe findReceipeById(Long receipeId) throws Exception {
		Optional<Receipe> receipe = receipeRepository.findById(receipeId);

		if (receipe.isPresent()) {
			return receipe.get();
		} else {
			throw new Exception("Receipe not found with id :: " + receipeId);
		}
	}

	@Override
	public String deleteReceipe(Long receipeId) throws Exception {

		Receipe receipeById = findReceipeById(receipeId);
		if (receipeById == null) {
			throw new Exception("Receipe is not Exist");
		} else {
			receipeRepository.deleteById(receipeId);
			return "Receipe Deleted Successfully!...";
		}

	}

	@Override
	public Receipe updateReceipe(Receipe receipe, Long receipeId) throws Exception {
		Receipe oldReceipe = findReceipeById(receipeId);
		if (oldReceipe == null) {
			throw new Exception("Receipe is not Exist");
		} else {
			if (receipe.getReceipeTitle() != null) {
				oldReceipe.setReceipeTitle(receipe.getReceipeTitle());
			}
			if (receipe.getImage() != null) {
				oldReceipe.setImage(receipe.getImage());
			}
			if (receipe.getDescription() != null) {
				oldReceipe.setDescription(receipe.getDescription());
			}

			return receipeRepository.save(oldReceipe);
		}
	}

	@Override
	public List<Receipe> findAllReceipes() {
		return receipeRepository.findAll();
	}

	@Override
	public Receipe likeReceipe(Long receipeId, User user) throws Exception {
		Receipe receipe = findReceipeById(receipeId);
		if (receipe == null) {
			throw new Exception("Receipe is not Exist");
		} else {
			if(receipe.getLikes().contains(user.getUserId())){
				receipe.getLikes().remove(user.getUserId());
			} else {
				receipe.getLikes().add(user.getUserId());
			}
		}
		return receipeRepository.save(receipe);
	}

}
