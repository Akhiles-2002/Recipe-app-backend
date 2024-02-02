package in.com.service;

import java.util.List;

import in.com.model.Receipe;
import in.com.model.User;

public interface ReceipeService {

	public Receipe createReceipe(Receipe receipe, User user);

	public Receipe findReceipeById(Long receipeId) throws Exception;

	public String deleteReceipe(Long receipeId) throws Exception;

	public Receipe updateReceipe(Receipe receipe, Long receipeId) throws Exception;

	public List<Receipe> findAllReceipes();

	public Receipe likeReceipe(Long receipeId, User user) throws Exception;

}
