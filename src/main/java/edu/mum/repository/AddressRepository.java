package edu.mum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Address;
import edu.mum.domain.Payment;
import edu.mum.domain.UserOrder;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
	
	List<Address> findAll();
	
}
