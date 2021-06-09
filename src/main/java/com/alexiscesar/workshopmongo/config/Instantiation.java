package com.alexiscesar.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alexiscesar.workshopmongo.domain.Post;
import com.alexiscesar.workshopmongo.domain.User;
import com.alexiscesar.workshopmongo.dto.AuthorDTO;
import com.alexiscesar.workshopmongo.repository.PostRepository;
import com.alexiscesar.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, Instant.parse("2021-08-20T11:53:54Z"), "Pizza", "Eu amo pizza de 5 queijos", new AuthorDTO(alex));
		Post post2 = new Post(null, Instant.parse("2021-08-22T15:10:21Z"), "Unicornios", "Eu quero um de estimação!", new AuthorDTO(maria));
		Post post3 = new Post(null, Instant.parse("2021-08-24T18:31:45Z"), "Ouvindo - Oh Wonder, Lose it", "Melhor música de todas", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
	}

}
