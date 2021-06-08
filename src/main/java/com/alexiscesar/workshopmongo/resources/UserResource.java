package com.alexiscesar.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexiscesar.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET) //Pode ser @GetMapping apenas.
	public ResponseEntity<List<User>> findAll() {
		
		User alexis = new User("1", "alexis", "alexis@space.com");
		User julia = new User("2", "julia", "julia@space.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(alexis, julia));
		
		return ResponseEntity.ok().body(list);
	}
	
}
