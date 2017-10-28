package edu.mum.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.User;


//import edu.mum.domain.UserCredentials;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	@Query("SELECT u FROM User u WHERE u.id = :id")
	public User findByUserId(Long id);
	

}
