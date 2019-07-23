package com.lambdaschool.zoos.repos;

import com.lambdaschool.zoos.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}

