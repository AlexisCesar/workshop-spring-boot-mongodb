package com.alexiscesar.workshopmongo.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexiscesar.workshopmongo.domain.Post;
import com.alexiscesar.workshopmongo.repository.PostRepository;
import com.alexiscesar.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Instant minDate, Instant maxDate) {
		maxDate = maxDate.plus(1, ChronoUnit.DAYS);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
