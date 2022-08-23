package dev.starhound.piecemeal.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.starhound.piecemeal.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	Optional<User> findByEmail(String email);

}