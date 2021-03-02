package Fusion.Internship.DAO;

import Fusion.Internship.Database.User;

public interface BasicDAO {
	
	User getUser(User user);
	
	User insertUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	void printUser(User user);
}
