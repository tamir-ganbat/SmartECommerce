package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Login;
import edu.mum.domain.User;
import edu.mum.repository.LoginRepository;
import edu.mum.repository.UserRepository;
import edu.mum.service.LoginService;
import edu.mum.service.UserService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public void save(Login user) {
		// TODO Auto-generated method stub
		loginRepository.save(user);
	}

	@Override
	public List<Login> findAll() {
		// TODO Auto-generated method stub
		return (List<Login>) loginRepository.findAll();
	}

	@Override
	public Login findOne(Long id) {
		// TODO Auto-generated method stub
		return loginRepository.findOne(id);
	}

	@Override
	public Login findByUsername(String username) {
		// TODO Auto-generated method stub
		return loginRepository.findByUsername(username);
	}

	@Override
	public Login findByPassword(String password) {
		// TODO Auto-generated method stub
		return loginRepository.findByPassword(password);
	}
	
	
	
}
