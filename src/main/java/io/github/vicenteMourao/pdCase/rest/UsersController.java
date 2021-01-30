package io.github.vicenteMourao.pdCase.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.vicenteMourao.pdCase.model.Users;
import io.github.vicenteMourao.pdCase.repository.UsersRepository;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin("*")
public class UsersController {
	@Autowired
	private UsersRepository repository;
	@GetMapping
	public  List<Users> findAll(){
		return repository.findAll();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Users save (@RequestBody Users users) {
		return repository.save(users);
	}
	
	@GetMapping("{id}")
	public Users getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	
	@DeleteMapping("{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		 repository.findById(id)
		 .map(users ->{
			 repository.delete(users);
			 return Void.TYPE;
		 })
		 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	

	 
	
	@PutMapping("{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void editUser(@PathVariable long id, @RequestBody Users userAtualizado) {
		repository.findById(id)
		 .map(users ->{
				users.setName(userAtualizado.getName());
				users.setSurname(userAtualizado.getSurname());
				users.setUsername(userAtualizado.getUsername());
				users.setPassword(userAtualizado.getPassword());
				users.setEmail(userAtualizado.getEmail());
				users.setPhone(userAtualizado.getPhone());
				return repository.save(userAtualizado);
		 })
		 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
   
	public List<Users> findAll(@PathVariable Long id) {
		return repository.findAll();
	}
	
	
}
