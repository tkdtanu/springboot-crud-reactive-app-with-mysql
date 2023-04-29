package com.tkd.user.crud.app.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.tkd.user.crud.app.entity.User;

@Repository
public interface UserRepository extends R2dbcRepository<User, Integer> {
	
}
