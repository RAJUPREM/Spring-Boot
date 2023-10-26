package com.comjava.Reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comjava.Entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
