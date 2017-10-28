package edu.mum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.UserOrder;

@Repository
public interface UserOrderRepository extends CrudRepository<UserOrder, Long> {
	
	List<UserOrder> findAll();
	
//	@Query(value="SELECT o FROM UserOrder o LEFT JOIN User u ON u.id = o.userI = :userId")
//	List<UserOrder> findOrdersByUserId(@Param("userId") int userId);
}
