package edu.mum.service;

import java.util.List;

import edu.mum.domain.Login;
import edu.mum.domain.User;

public interface LoginService {
	
	public void save(Login login);	

	public List<Login> findAll();
	public Login findOne(Long id);
	public Login findByUsername(String username);
	public Login findByPassword(String password);

	//public Login findByUserId(Long loginId);

}
