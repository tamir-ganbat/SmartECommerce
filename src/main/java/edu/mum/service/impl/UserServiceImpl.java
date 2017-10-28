package edu.mum.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Authority;
import edu.mum.domain.User;
import edu.mum.repository.UserRepository;
import edu.mum.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void save(User user) {
		// String password = "admin";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// String hashedPassword = passwordEncoder.encode(password);
		// System.out.println(user.getUserCredentials().getPassword());

		List<Authority> creds = new ArrayList<>();
		creds.add(new Authority(user.getUserCredentials(), user.getUserCredentials().getUsername(), "ROLE_USER"));

		user.getUserCredentials().setAuthority(creds);

		String encodedPassword = passwordEncoder.encode(user.getUserCredentials().getPassword());
		// System.out.println("Here for testing....." + encodedPassword);
		user.getUserCredentials().setPassword(encodedPassword);

		user.getUserCredentials().setEnabled(true);
		// try {
		// appendToFile(user,encodedPassword);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		userRepository.save(user);
	}

	public void appendToFile(User user, String psw) throws IOException {

		String path = "/src/sql/populate.sql";
		String str = "INSERT INTO credentials(username,password,enabled) VALUES ("
				+ user.getUserCredentials().getUsername() + "," + psw + ", TRUE)";
		String str1 = "INSERT INTO authority (username, authority) VALUES (" + user.getUserCredentials().getUsername()
				+ ", ROLE_USER)";
		BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
		writer.append(" ");
		writer.append(str);
		writer.close();
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(path, true));
		writer1.append(" ");
		writer1.append(str1);
		writer1.close();

	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findByUserId(Long userId) {
		return userRepository.findByUserId(userId);
	}

}
