package agenda.repository.interfaces;

import java.util.List;

import agenda.model.User;

public interface RepositoryUser {

	User getByUsername(String username);
	User getByName(String name);
	
	boolean changePasswd(User user, String oldPasswd, String newPasswd);
	
	boolean save();
	
	List<User> getUsers();
	int getCount();
	
}
