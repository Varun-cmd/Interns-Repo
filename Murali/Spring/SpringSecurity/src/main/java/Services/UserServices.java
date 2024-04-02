package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.User;
import Repositories.UserRepository;


@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
}
