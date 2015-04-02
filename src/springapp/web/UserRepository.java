package springapp.web;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import forms.User;

public interface UserRepository extends MongoRepository<User, String> {

	public User findByUserName(String username);

	public List<User> findByPassword(String password);

}
