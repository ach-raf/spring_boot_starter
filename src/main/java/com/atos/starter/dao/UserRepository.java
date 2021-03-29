package com.atos.starter.dao;

import com.atos.starter.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	// Spring boot take care of our database calls.
}
