package edu.mum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Login;
import edu.mum.domain.User;
//import edu.mum.domain.UserCredentials;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long>{
//	@Query("SELECT u FROM Login u WHERE u.id = :id")
//	public User findByUserId(Long id);
	@Query("SELECT l FROM Login l WHERE l.username = :username")
	public Login findByUsername(String username);
	
	@Query("SELECT l FROM Login l WHERE l.password = :password")
	public Login findByPassword(String password);

}

